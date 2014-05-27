package com.endava.imdb.search.worker;

import com.endava.imdb.search.domain.jackson.pooling.QueryResultJson;
import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.result.QueryResult;
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
 */

@Service
@Scope("prototype")
public class PoolingServerSearchTask implements  SearchTask {

    private final static String urlTemplatePooling = "http://localhost:8082/movies/{query}";

    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private ObjectMapper jacksonMapper;



//    public PoolingServerSearchTask(String query) {
//        this.query = query;
//    }

    @Override
    public void run() {
        System.out.println("Pooling Server Task");
        Map<String, String> urlVars = new HashMap<String, String>();
        urlVars.put("query", query);

        RestTemplate restTemplate = new RestTemplate();

        try{
            System.out.println("POOOLING "+urlTemplatePooling);
            ResponseEntity<QueryResultJson> searchRequestResponse = restTemplate.getForEntity(urlTemplatePooling, QueryResultJson.class, urlVars);
            System.out.println("FIRST RESPONSE "+searchRequestResponse.getBody().toString());
            String responseLocation = searchRequestResponse.getBody().getDetail();
            System.out.println("Pooling response location "+responseLocation);

            ResponseEntity<String> searchReferenceResponse = null;

            while(true){
                System.out.println("Entering while loop");
                searchReferenceResponse = restTemplate.getForEntity(responseLocation, String.class);
                System.out.println(searchReferenceResponse.getBody());
                System.out.println(searchReferenceResponse.getStatusCode().value());

                if(searchReferenceResponse.getStatusCode().value() == 200){
                    System.out.println("Yaaay => 200 status code");
                    break;
                }

                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            //TvSeriesJson[] results = restTemplate.getForObject(responseLocation, TvSeriesJson[].class);
            List<TvSeriesJson> results = null;
            try {
                System.out.println("RESULT in try "+searchReferenceResponse.getBody());
                results = jacksonMapper.readValue(searchReferenceResponse.getBody(), new TypeReference<List<TvSeriesJson>>() { });
                System.out.println(results.size());
                System.out.println("POOLING RESULT "+results.toString());
                queryResult.setPoolingServerResult(results);
                System.out.println("Saved query result from pooling "+queryResult.getPoolingServerResult().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }catch(HttpClientErrorException e){
            if(e.getMessage().equals("406 Not Acceptable")){
                System.out.println("Invalid query");
            }
        }

    }
}
