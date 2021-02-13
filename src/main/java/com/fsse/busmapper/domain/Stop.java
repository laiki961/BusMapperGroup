package com.fsse.busmapper.domain;

import javax.persistence.*;

@Entity
public class Stop {
    @Id
    private String stopId;
    @Column
    private String stopname;
    @Column(name = "latitude", columnDefinition = "DECIMAL(15,13)")
    private String latitude;
    @Column(name = "longitude", columnDefinition = "DECIMAL(16,13)")
    private String longitude;

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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
