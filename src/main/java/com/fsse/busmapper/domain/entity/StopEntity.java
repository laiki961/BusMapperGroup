package com.fsse.busmapper.domain.entity;

import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class StopEntity {

    @Id
    private String stopId;
    @Column
    private String stopname;
    @Column(name = "latitude", columnDefinition = "DECIMAL(15,13)")
    private Double latitude;
    @Column(name = "longitude", columnDefinition = "DECIMAL(16,13)")
    private Double longitude;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stop")
    List<RouteStopEntity> routeStopEntities;


    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopname='" + stopname + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
