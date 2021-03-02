package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteStopEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class BusEtaIntDO {
    @Autowired
    private RouteStopEntity routeStopEntity;
    private String route;
    private String dir;
    private String oriStop;
    private String destStop;

    private String stopsSeq;
    private String stopsStop;
    private String stopname;
    private Double stopLat;
    private Double stopLng;


    public RouteStopEntity getRouteStopEntity() {
        return routeStopEntity;
    }

    public void setRouteStopEntity(RouteStopEntity routeStopEntity) {
        this.routeStopEntity = routeStopEntity;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getOriStop() {
        return oriStop;
    }

    public void setOriStop(String oriStop) {
        this.oriStop = oriStop;
    }

    public String getStopsSeq() {
        return stopsSeq;
    }

    public void setStopsSeq(String stopsSeq) {
        this.stopsSeq = stopsSeq;
    }

    public String getDestStop() {
        return destStop;
    }

    public void setDestStop(String destStop) {
        this.destStop = destStop;
    }

    public String getStopsStop() {
        return stopsStop;
    }

    public void setStopsStop(String stopsStop) {
        this.stopsStop = stopsStop;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public Double getStopLat() {
        return stopLat;
    }

    public void setStopLat(Double stopLat) {
        this.stopLat = stopLat;
    }

    public Double getStopLng() {
        return stopLng;
    }

    public void setStopLng(Double stopLng) {
        this.stopLng = stopLng;
    }

    @Override
    public String toString() {
        return "BusEtaIntDO{" +
                "routeStopEntity=" + routeStopEntity +
                ", route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", oriStop='" + oriStop + '\'' +
                ", destStop='" + destStop + '\'' +
                ", stopsSeq='" + stopsSeq + '\'' +
                ", stopsStop='" + stopsStop + '\'' +
                ", stopname='" + stopname + '\'' +
                ", stopLat=" + stopLat +
                ", stopLng=" + stopLng +
                '}';
    }
}

