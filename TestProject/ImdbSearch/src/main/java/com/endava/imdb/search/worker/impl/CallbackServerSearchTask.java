package com.endava.imdb.search.worker.impl;

import com.endava.imdb.search.domain.jackson.tvrage.SimpleResponse;
import com.endava.imdb.search.worker.SearchTask;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bianca on 5/25/2014.
 *
 * This is a template thread for forwarding the query to the callback server, by giving it the link to the callback controller where it can post the results.
 * In order to do this, the thread makes use of the query String and to the URL corresponding to the callback controller.
 * The needed results are not received here, but in the callback controller, where the session ID of the user is taken into consideration in order to store them accordingly.
 */

@Service
@Scope("prototype")
public class CallbackServerSearchTask implements SearchTask {

    private  final static String URL_TEMPLATE_CALLBACK = "http://localhost:8083/tvrage/query/{query}?callback=http://localhost:8080/callback";

    private String query;

    @Autowired
    private ObjectMapper jacksonMapper;



    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }




    @Override
    public void run() {
        Map<String, String> urlVars = new HashMap<String, String>();
        urlVars.put("query", query);

        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<SimpleResponse> firstResponse =
                    restTemplate.getForEntity(URL_TEMPLATE_CALLBACK, SimpleResponse.class, urlVars);

        }catch(HttpServerErrorException e){
            System.out.println("Error from callback search task "+e.getMessage());
        }



    }
}
