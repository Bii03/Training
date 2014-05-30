package com.endava.imdb.search.worker.impl;

import com.endava.imdb.search.domain.jackson.tracktv.QueryResultJson;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.worker.SearchTask;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bianca on 5/25/2014.
 *
 * This is a template thread for forwarding the query to the sync server and get the needed results.
 * In order to do this, the thread makes use of the query String and the session ID of the corresponding user.
 * The final results are stored in a commonplace bean, QueryResult.
 */
@Service
@Scope("prototype")
public class SyncServerSearchTask implements SearchTask {

    private String query;

    private String sessionId;

    public static final String urlTemplate = "http://localhost:8081/tracktv?query={query}";

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private ObjectMapper jacksonMapper;


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
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlVars = new HashMap<String, String>();
        urlVars.put("query", query);

        try{
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlTemplate, String.class, urlVars);

            QueryResultJson result = jacksonMapper.readValue(responseEntity.getBody(), QueryResultJson.class);

            queryResult.setSyncServerResultPerSession(this.sessionId, result.getContent());

        } catch (JsonMappingException e) {
            System.out.println("Error from sync search task "+e.getMessage());
        } catch (JsonParseException e) {
            System.out.println("Error from sync search task "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error from sync search task "+e.getMessage());
        }catch(HttpClientErrorException e){
            System.out.println("Error from sync search task "+e.getMessage());
        }


    }
}
