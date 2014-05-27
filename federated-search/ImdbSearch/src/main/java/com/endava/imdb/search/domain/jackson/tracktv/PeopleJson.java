package com.endava.imdb.search.domain.jackson.tracktv;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by btesila on 5/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PeopleJson {
    private List<ActorJson> actors;

    public List<ActorJson> getActors() {
        return actors;
    }

    public void setActors(List<ActorJson> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "PeopleJson{" +
                "actors=" + actors +
                '}';
    }
}
