package com.endava.imdb.search.controller;

import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jackson.tvrage.SimpleResponse;
import com.endava.imdb.search.result.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by Bianca on 5/24/2014.
 *
 * This is the callback used by the callback server in order to post the results corresponding to the user's search query.
 * It has a post method which receives as request body parameter the list of results given by the server.
 * In order to store the results, the controller method makes use of the user's session ID and puts them in a commonplace bean, QueryResult.
 */
@Controller
public class CallbackController {

    @Autowired
    private QueryResult queryResult;


    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Callable<String> search(HttpSession session, @RequestBody final List<ShowInfo> showInfos, final ModelMap model) {

        String sessionId = session.getId();
        queryResult.setCallbackServerResultPerSession(sessionId, showInfos);

        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1000L);
                return "result received";
            }
        };

    }
}
