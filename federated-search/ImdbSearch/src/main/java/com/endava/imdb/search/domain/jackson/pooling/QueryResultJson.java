package com.endava.imdb.search.domain.jackson.pooling;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by btesila on 5/23/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryResultJson {
    private String message;
    private String detail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "QueryResultJson{" +
                "message='" + message + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
