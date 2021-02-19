package com.fsse.busmapper.domain.entity;

import com.fsse.busmapper.domain.Route;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routeStop")
public class RouteStopEntity {
    @Id
    @Column(name = "routeStopId", nullable = true, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeStopId;

    @JoinColumn(name = "routeId", columnDefinition =  "VARCHAR(255)", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private RouteEntity routeId;

    @Column(name = "direction", columnDefinition =  "VARCHAR(255)", nullable = false)
    private String dir;

    @Column(name = "bus_company_name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String co;

    @Column(name = "sequence", columnDefinition = "INTEGER", nullable = false)
    private Integer seq;

    @JoinColumn(name = "stopId", columnDefinition = "VARCHAR(255)", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public StopEntity getStop() {
        return stop;
    }

    public void setStop(StopEntity stop) {
        this.stop = stop;
    }

    public RouteEntity getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteEntity routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "RouteStopEntity{" +
                "routeStopId=" + routeStopId +
                ", co='" + co + '\'' +
                ", dir='" + dir + '\'' +
                ", seq=" + seq +
                ", stop=" + stop +
                '}';
    }

}
