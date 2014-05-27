package com.endava.imdb.search.domain.jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Bianca on 5/25/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Akas {
    private List<Aka> aka;

    public List<Aka> getAka() {
        return aka;
    }

    public void setAka(List<Aka> aka) {
        this.aka = aka;
    }

    @Override
    public String toString() {
        return "Akas{" +
                "aka=" + aka +
                '}';
    }
}
