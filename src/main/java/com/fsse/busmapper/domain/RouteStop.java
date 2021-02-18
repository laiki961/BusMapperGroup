package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.ArrayList;
import java.util.List;

public class RouteStop {
    private String co;
    private String routeId;
    private String dir;
    private int seq;
    private String stopId;
    private Integer routeStopId;

    public static List<RouteStopEntity> toRouteStopEntity(List<RouteStop> routeStop){
        List<RouteStopEntity> routeStopEntities = new ArrayList<>();
        for(int i=0; i<routeStop.size(); i++) {
            RouteStopEntity routeStopEntity = new RouteStopEntity();
            routeStopEntity.setRouteStopId(routeStop.get(i).getRouteStopId());
            routeStopEntity.setCo(routeStop.get(i).getCo());
            routeStopEntity.setDir(routeStop.get(i).getDir());
            routeStopEntity.setSeq(routeStop.get(i).getSeq());
            routeStopEntity.setRouteId(routeStop.get(i).getRouteId());
            StopEntity stopEntity = new StopEntity();
            stopEntity.setStopId(routeStop.get(i).getStopId());
            stopEntity.setStopname(null);
            stopEntity.setLatitude(null);
            stopEntity.setLongitude(null);
            routeStopEntity.setStop(stopEntity);
            routeStopEntities.add(routeStopEntity);
        }
        return routeStopEntities;
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

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public Integer getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(Integer routeStopId) {
        this.routeStopId = routeStopId;
    }

    @Override
    public String toString() {
        return "RouteStop{" +
                "co='" + co + '\'' +
                ", routeId='" + routeId + '\'' +
                ", dir='" + dir + '\'' +
                ", seq=" + seq +
                ", stopId='" + stopId + '\'' +
                ", routeStopId=" + routeStopId +
                '}';
    }
}
