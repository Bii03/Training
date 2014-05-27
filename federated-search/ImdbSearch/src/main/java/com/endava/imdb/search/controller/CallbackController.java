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

import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by Bianca on 5/24/2014.
 */
@Controller
public class CallbackController {

    @Autowired
    private QueryResult queryResult;

    private static int called=0;
    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Callable<String> search(@RequestBody final List<ShowInfo> showInfos, final ModelMap model) {
        System.out.println("entered async controller method"+(called++));
                for(ShowInfo show: showInfos){
            System.out.println(called+" "+show);
        }
        queryResult.setCallbackServerResult(showInfos);
        System.out.println("Saved query result from callback "+queryResult.getCallbackServerResult().toString());
        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000L);
                model.addAttribute("messageTvRageList", showInfos);
                System.out.println("about to return from call()");
                return "result";
            }
        };

    }
}
