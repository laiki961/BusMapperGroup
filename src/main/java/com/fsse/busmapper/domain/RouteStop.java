package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

public class RouteStop {
    private String co;
    private String routeId;
    private String dir;
    private int seq;
    private String stopId;

    public RouteStopEntity toRouteStopEntity() {
        RouteStopEntity entity = new RouteStopEntity();
        entity.setCo(getCo());
        entity.setRouteId(getRouteId());
        entity.setDir(getDir());
        entity.setSeq(getSeq());

        return entity;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

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

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    @Override
    public String toString() {
        return "RouteStop{" +
                "co='" + co + '\'' +
                ", routeId='" + routeId + '\'' +
                ", dir='" + dir + '\'' +
                ", seq=" + seq +
                ", stopId='" + stopId + '\'' +
                '}';
    }
}
