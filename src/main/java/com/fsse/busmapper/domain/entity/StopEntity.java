package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "stop")
public class StopEntity {

    @Id
    private String stopId;
    private String stopName;
    private Double lat;
    private Double lng;

    @OneToMany(mappedBy = "stopId")
    private List<RouteStop> routeStops;

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public List<RouteStop> getRouteStops() {
        return routeStops;
    }

    public void setRouteStops(List<RouteStop> routeStops) {
        this.routeStops = routeStops;
    }

    @Override
    public String toString() {
        return "StopEntity{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", routeStops=" + routeStops +
                '}';
    }
}
