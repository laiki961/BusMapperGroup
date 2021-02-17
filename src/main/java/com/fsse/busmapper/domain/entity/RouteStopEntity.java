package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
public class RouteStopEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String routeStopId;
    @Column
    private String routeId;
    @Column
    private String dir;
    @Column
    private int seq;

    @JoinColumn(name = "stopId")
    @ManyToOne(fetch = FetchType.LAZY)
    private StopEntity stop;
    @Column
    private String co;


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

    public StopEntity getStop() {
        return stop;
    }

    public void setStop(StopEntity stop) {
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
