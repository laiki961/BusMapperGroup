package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "routeStop")
public class RouteStopEntity {
    @Id
    @Column(name = "route_stop_id", nullable = true, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeStopId;

    @JoinColumn(name = "route_id", columnDefinition =  "VARCHAR(255)", nullable = false)
    @ManyToOne//(cascade = CascadeType.ALL)
    private RouteEntity routeEntity;

    @Column(name = "direction", columnDefinition =  "VARCHAR(255)", nullable = false)
    private String dir;

    @Column(name = "bus_company_name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String co;

    @Column(name = "sequence", columnDefinition = "INTEGER", nullable = false)
    private Integer seq;

    @JoinColumn(name = "stop_id", columnDefinition = "VARCHAR(255)", nullable = false, referencedColumnName = "stopId")
    @ManyToOne//(cascade = CascadeType.ALL)
    private StopEntity stopEntity;

    public Integer getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(Integer routeStopId) {
        this.routeStopId = routeStopId;
    }

    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public StopEntity getStopEntity() {
        return stopEntity;
    }

    public void setStopEntity(StopEntity stopEntity) {
        this.stopEntity = stopEntity;
    }

    @Override
    public String toString() {
        return "RouteStopEntity{" +
                "routeStopId=" + routeStopId +
                ", routeEntity=" + routeEntity +
                ", dir='" + dir + '\'' +
                ", co='" + co + '\'' +
                ", seq=" + seq +
                ", stopEntity=" + stopEntity +
                '}';
    }
}
