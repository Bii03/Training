package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by btesila on 5/20/2014.
 */

@Controller
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getMovie(@PathVariable String name, ModelMap model) {

        model.addAttribute("movie", name);

        //The name of the corresponding view(jsp file)
        return "list";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultMovie(ModelMap model) {

        model.addAttribute("movie", "this is default movie");
        return "list";

    }

}
