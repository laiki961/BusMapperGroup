package com.fsse.busmapper.domain.entity;

import java.util.List;

public class BusEntity {
    private List<RouteStopEntity> routeStopEntityList;

    public List<RouteStopEntity> getRouteStopEntityList() {
        return routeStopEntityList;
    }

    public void setRouteStopEntityList(List<RouteStopEntity> routeStopEntityList) {
        this.routeStopEntityList = routeStopEntityList;
    }

    @Override
    public String toString() {
        return "BusEntity{" +
                "routeStopEntityList=" + routeStopEntityList +
                '}';
    }
}
