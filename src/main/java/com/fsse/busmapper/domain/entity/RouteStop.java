package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
public class RouteStop {
    @Id
    private String routeId;
    @Column
    private String dir;
    @Column
    private int seq;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Stop stop;


    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getDirection() {
        return dir;
    }

    public void setDirection(String direction) {
        this.dir = dir;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }


    @Override
    public String toString() {
        return "RouteStop{" +
                "routeId='" + routeId + '\'' +
                ", direction='" + dir + '\'' +
                ", seq=" + seq +
                ", stopId='" + stop + '\'' +
                '}';
    }
}
