package com.endava.imdb.search.worker;

import com.endava.imdb.search.domain.jackson.tvrage.SimpleResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * Created by Bianca on 5/25/2014.
 */

@Service
@Scope("prototype")
public class CallbackServerSearchTask implements SearchTask{

    private String query;

    private  static String urlTemplateTvRage = "http://localhost:8083/tvrage/query/";
    private final static String urlCallback = "http://localhost:8080/callback";

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public void run() {
        System.out.println("Callback Server Task");

        RestTemplate restTemplate = new RestTemplate();
        try {
            urlTemplateTvRage = urlTemplateTvRage+query+"?callback=" + URLEncoder.encode(urlCallback, "UTF-8");
            System.out.println("Callback RS Encoded url: "+urlTemplateTvRage);
            ResponseEntity<SimpleResponse> firstResponse = restTemplate.getForEntity(new URI(urlTemplateTvRage), SimpleResponse.class);
            System.out.println("Callback first response "+firstResponse.getBody().toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
