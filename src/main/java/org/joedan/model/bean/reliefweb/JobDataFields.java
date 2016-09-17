package org.joedan.model.bean.reliefweb;

import java.util.Set;

public class JobDataFields {

    private int id;

    private String title;

    private Set<SourceData> source;

    private String status;

    private TimeData date;

    private String url;

    private Set<CityData> city;

    private Set<CountryData> country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SourceData> getSource() {
        return source;
    }

    public void setSource(Set<SourceData> source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TimeData getDate() {
        return date;
    }

    public void setDate(TimeData date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<CityData> getCity() {
        return city;
    }

    public void setCity(Set<CityData> city) {
        this.city = city;
    }

    public Set<CountryData> getCountry() {
        return country;
    }

    public void setCountry(Set<CountryData> country) {
        this.country = country;
    }
}
