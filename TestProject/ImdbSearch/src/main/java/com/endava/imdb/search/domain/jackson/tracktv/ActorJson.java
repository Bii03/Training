package com.endava.imdb.search.domain.jackson.tracktv;

import com.endava.imdb.search.domain.jpa.ActorEntity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by btesila on 5/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ActorJson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ActorJson{" +
                "name='" + name + '\'' +
                '}';
    }


}
