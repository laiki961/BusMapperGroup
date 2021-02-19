package com.fsse.busmapper.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="stop")
public class StopEntity {

    @Id
//    @Column(name = "stop_id", columnDefinition = "VARCHAR(255)", nullable = false)
//    @OneToMany(fetch = FetchType.LAZY)
    private String stopId;
    @Column//(name = "stop name", columnDefinition = "VARCHAR(255)")
    private String stopname;
    @Column(name = "latitude", columnDefinition = "DECIMAL(15,13)")
    private Double latitude;
    @Column(name = "longitude", columnDefinition = "DECIMAL(16,13)")
    private Double longitude;
//    @OneToMany(mappedBy = "stop")
//    List<RouteStopEntity> routeStopEntities;

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
