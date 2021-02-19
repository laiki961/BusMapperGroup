package com.fsse.busmapper.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
//    @OneToMany(mappedBy = "routeId")
    private String routeId;
    @Column(name = "origin", columnDefinition =  "VARCHAR(255)", nullable = false)
    private String orig;
    @Column(name = "destination", columnDefinition =  "VARCHAR(255)", nullable = false)
    private String dest;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "RouteEntity{" +
                "routeId='" + routeId + '\'' +
                ", orig='" + orig + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
