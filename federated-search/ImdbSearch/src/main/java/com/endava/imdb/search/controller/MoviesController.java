package com.endava.imdb.search.controller;

import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tracktv.QueryResultJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.form.Query;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.service.SearchService;
import com.endava.imdb.search.service.impl.MergeResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by btesila on 5/22/2014.
 */

@Controller
public class MoviesController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private MergeResultService mergeResultService;



    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String search(@RequestParam(required = false) String query, ModelMap model) {
        System.out.println("Process form");
        if(query != null){
            System.out.println("Query result "+queryResult);
            queryResult.setCallbackServerResult(new ArrayList<ShowInfo>());
            queryResult.setPoolingServerResult(new ArrayList<TvSeriesJson>());
            queryResult.setSyncServerResult(new ArrayList<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>());
            List<TvSeriesEntity> tvSeriesEntities = searchService.searchFor(query);
            System.out.println("YAY, got the final result!"+tvSeriesEntities.toString());
            model.addAttribute("results", tvSeriesEntities);
        }

        return "movies";
    }

}
