package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stop {

    private String stopId;
    private String stopname;
    private Double latitude;
    private Double longitude;

    public StopEntity toStopEntity() {
        StopEntity entity = new StopEntity();
        entity.setStopId(getStopId());
        entity.setStopname(getStopname());
        entity.setLatitude(getLatitude());
        entity.setLongitude(getLongitude());
        return entity;
    }


    private Set<StopEntity> storedStop = new HashSet<>();

    public Set<StopEntity> getStoredStop() {
        return storedStop;
    }

    public void setStoredStop(Set<StopEntity> storedStop) {
        this.storedStop = storedStop;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopname='" + stopname + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
