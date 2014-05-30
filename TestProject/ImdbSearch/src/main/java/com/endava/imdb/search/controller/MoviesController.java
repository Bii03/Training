package com.endava.imdb.search.controller;

import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.service.SearchService;
import com.endava.imdb.search.service.impl.MergeResultServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by btesila on 5/22/2014.
 *
 */

@Controller
public class MoviesController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private MergeResultServiceImplementation mergeResultServiceImplementation;


    /**
     * This is the controller for get requests to Movies page. Whenever a user enters a search query, the same controller
     * will be triggered.
     * In order to get the corresponding results for each user, the method makes use of the session ID of the user. Then,
     * the search service is used, returning a list of TvSeriesEntity. Afterwards, all the results stored for the corresponding
     * session Id are deleted in order to make sure that the next results for the same user are not mixed up with these ones.
     * @param session
     * @param query
     * @param model
     * @return
     */
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String search(HttpSession session, @RequestParam(required = false) String query, ModelMap model) {

        String sessionId = session.getId();

        if(query != null){

            queryResult.setCallbackServerResultPerSession(sessionId, new ArrayList<ShowInfo>());
            queryResult.setPoolingServerResultPerSession(sessionId, new ArrayList<TvSeriesJson>());
            queryResult.setSyncServerResultPerSession(sessionId, new ArrayList<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>());

            List<TvSeriesEntity> tvSeriesEntities = searchService.searchFor(query, sessionId);

            queryResult.getCallbackServerResult().remove(sessionId);
            queryResult.getPoolingServerResult().remove(sessionId);
            queryResult.getSyncServerResult().remove(sessionId);

            model.addAttribute("results", tvSeriesEntities);
        }

        return "movies";
    }

}
