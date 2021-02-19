package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.StopEntity;

import javax.persistence.criteria.CriteriaBuilder;

public class Stop {
    private String stopId;
    private String stopName;
    private Double lat;
    private Double lng;

    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Stop{" +
                ", stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
