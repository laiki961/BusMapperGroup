package com.fsse.busmapper.domain;

import java.util.ArrayList;
import java.util.List;

public class Eta {
    private String routeId;
    private String dir;

    private List<Stop> stops;

    private Integer stopId;
    private String estTimestamp;

    private Integer destinationStop;


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public String getEstTimestamp() {
        return estTimestamp;
    }

    public void setEstTimestamp(String estTimestamp) {
        this.estTimestamp = estTimestamp;
    }

    public Integer getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(Integer destinationStop) {
        this.destinationStop = destinationStop;
    }

    @Override
    public String toString() {
        return "Eta{" +
                "routeId='" + routeId + '\'' +
                ", dir='" + dir + '\'' +
                ", stops=" + stops +
                ", stopId=" + stopId +
                ", estTimestamp='" + estTimestamp + '\'' +
                ", destinationStop=" + destinationStop +
                '}';
    }
}
