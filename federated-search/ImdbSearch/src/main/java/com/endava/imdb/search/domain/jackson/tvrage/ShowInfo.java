package com.endava.imdb.search.domain.jackson.tvrage;

import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Bianca on 5/24/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class ShowInfo {
    private String airtime;
    private String showid;
    private String status;
    private String runtime;
    private String airday;
    private Network network;
    private String origin_country;
    private String timezone;
    private String startdate;
    private String seasons;
    private String classification;
    private String showname;
    private Akas akas;
    private String started;
    private String showlink;

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAirday() {
        return airday;
    }

    public void setAirday(String airday) {
        this.airday = airday;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public Akas getAkas() {
        return akas;
    }

    public void setAkas(Akas akas) {
        this.akas = akas;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink;
    }

    @Override
    public String toString() {
        return "ShowInfo{" +
                "airtime='" + airtime + '\'' +
                ", showid='" + showid + '\'' +
                ", status='" + status + '\'' +
                ", runtime='" + runtime + '\'' +
                ", airday='" + airday + '\'' +
                ", network=" + network +
                ", origin_country='" + origin_country + '\'' +
                ", timezone='" + timezone + '\'' +
                ", startdate='" + startdate + '\'' +
                ", seasons='" + seasons + '\'' +
                ", classification='" + classification + '\'' +
                ", showname='" + showname + '\'' +
                ", akas=" + akas +
                ", started='" + started + '\'' +
                ", showlink='" + showlink + '\'' +
                '}';
    }

    public TvSeriesEntity getJPAEntity(){
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        tvSeriesEntity.setTitle(this.showname);
        tvSeriesEntity.setTvrage_id(this.showid);
        tvSeriesEntity.setUrl(this.showlink);
        tvSeriesEntity.setStatus(this.status);
        tvSeriesEntity.setCountry(this.origin_country);

        return tvSeriesEntity;
    }
}
