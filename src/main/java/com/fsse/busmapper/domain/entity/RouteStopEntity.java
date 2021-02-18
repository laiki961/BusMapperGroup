package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "routeStop")
public class RouteStopEntity {
    @Id
    @Column(name = "routeStopId", nullable = true, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeStopId;

    @Column(name = "bus_company_name",columnDefinition = "VARCHAR(255)",nullable = false)
    private String co;

    @Column(name = "direction",columnDefinition =  "VARCHAR(255)",nullable = false)
    private String dir;

    @Column(name = "sequence",columnDefinition = "INTEGER",nullable = false)
    private int seq;

    @Column
    private String routeId;

    @JoinColumn(name = "stopId")
    @ManyToOne(fetch = FetchType.LAZY)
    private StopEntity stop;

    public Integer getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(Integer routeStopId) {
        this.routeStopId = routeStopId;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
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

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public StopEntity getStop() {
        return stop;
    }

    public void setStop(StopEntity stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "RouteStopEntity{" +
                "routeStopId=" + routeStopId +
                ", co='" + co + '\'' +
                ", dir='" + dir + '\'' +
                ", seq=" + seq +
                ", routeId='" + routeId + '\'' +
                ", stop=" + stop +
                '}';
    }
}
