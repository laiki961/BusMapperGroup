package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;

public class Route {
    private String co;
    private String routeId;
    private String orig;
    private String dest;

    public RouteEntity toRouteEntity() {
        RouteEntity entity = new RouteEntity();
        entity.setRouteId(getRouteId());
        entity.setOrig(getOrig());
        entity.setDest(getDest());
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
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", orig='" + orig + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }

}
