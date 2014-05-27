package com.endava.imdb.search.worker;

import com.endava.imdb.search.domain.jackson.tracktv.QueryResultJson;
import com.endava.imdb.search.result.QueryResult;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bianca on 5/25/2014.    @Autowired
 private QueryResult queryResult;
 */
@Service
@Scope("prototype")
public class SyncServerSearchTask implements SearchTask{

    private String query;

    public static final String urlTemplate = "http://localhost:8081/tracktv?query={query}";


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

    @Override
    public void run() {
        System.out.println("Sync Server Task");
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlVars = new HashMap<String, String>();
        urlVars.put("query", query);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(urlTemplate, String.class, urlVars);
        System.out.println("Sync Server Result "+responseEntity.getBody().toString());
        System.out.println("Sync query result "+queryResult);
        try {
            QueryResultJson result = jacksonMapper.readValue(responseEntity.getBody(), QueryResultJson.class);
            queryResult.setSyncServerResult(result.getContent());
            System.out.println("Saved in query result from sync server "+queryResult.getSyncServerResult().toString());
        } catch (IOException e) {


        }




    }
}
