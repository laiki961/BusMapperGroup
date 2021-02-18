package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String co;
    private String routeId;
    private String orig;
    private String dest;

//    public static List<StopEntity> toStopEntity(List<Stop> stop){
//        List<StopEntity> stopEntities = new ArrayList<>();
//        for(int i=0; i<stop.size(); i++) {
//            StopEntity stopEntity = new StopEntity();
//            stopEntity.setStopId(stop.get(i).getStopId());
//            stopEntity.setStopname(stop.get(i).getStopname());
//            stopEntity.setLatitude(stop.get(i).getLatitude());
//            stopEntity.setLongitude(stop.get(i).getLongitude());
//            List<RouteStopEntity> routeStopEntities = new ArrayList<>();
//            routeStopEntities.set(routeStop.get(i).getStopId());
//            routeStopEntities.setStopname(null);
//            routeStopEntities.setLatitude(null);
//            routeStopEntities.setLongitude(null);
//            routeStopEntities.setStop(stopEntity);
//            routeStopEntities.add(routeStopEntity);
//        }
//        return routeStopEntities;
//    }

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
