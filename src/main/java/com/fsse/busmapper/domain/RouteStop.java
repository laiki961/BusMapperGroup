package com.fsse.busmapper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RouteStop {
    @Id
    private String routeId;
    @Column
    private String direction;
    @Column
    private int seq;
    @Column
    private String stopId;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
                "routeId='" + routeId + '\'' +
                ", direction='" + direction + '\'' +
                ", seq=" + seq +
                ", stopId='" + stopId + '\'' +
                '}';
    }
}
