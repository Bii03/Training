package com.endava.imdb.search.worker.impl;

import com.endava.imdb.search.domain.jackson.pooling.QueryResultJson;
import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.worker.SearchTask;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bianca on 5/25/2014.
 *
 * This is a template thread for forwarding the query to the pooling server and get the needed results.
 * In order to do this, the thread makes use of the query String and the session ID of the corresponding user.
 * The final results are stored in a commonplace bean, QueryResult.
 */

@Service
@Scope("prototype")
public class PoolingServerSearchTask implements SearchTask {

    private final static String URL_TEMPLATE_POOLING = "http://localhost:8082/movies/{query}";

    private final static int REQUEST_TRIAL_MAXIMUM_COUNT = 5;

    private int requestTrialCount;

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private ObjectMapper jacksonMapper;



    private String query;

    private String sessionId;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void run() {

        Map<String, String> urlVars = new HashMap<String, String>();
        urlVars.put("query", query);

        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<QueryResultJson> searchRequestResponse =
                    restTemplate.getForEntity(URL_TEMPLATE_POOLING, QueryResultJson.class, urlVars);

            String responseLocation = searchRequestResponse.getBody().getDetail();

            ResponseEntity<String> searchReferenceResponse = null;

            while(true){
                searchReferenceResponse = restTemplate.getForEntity(responseLocation, String.class);

                if(searchReferenceResponse.getStatusCode().value() == 200){
                    break;
                }
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            List<TvSeriesJson> results = jacksonMapper.readValue(searchReferenceResponse.getBody(),
                    new TypeReference<List<TvSeriesJson>>() { });

            queryResult.setPoolingServerResultPerSession(this.sessionId, results);

        }catch(HttpClientErrorException e){
            System.out.println("Error from pooling search task "+e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("Error from pooling search task "+e.getMessage());
        } catch (JsonParseException e) {
            System.out.println("Error from pooling search task "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error from pooling search task "+e.getMessage());
        }

    }
}
