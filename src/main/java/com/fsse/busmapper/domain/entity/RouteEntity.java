package com.fsse.busmapper.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    private String routeId;
    private String orig;
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
