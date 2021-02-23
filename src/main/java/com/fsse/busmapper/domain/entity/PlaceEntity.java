package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "Place_entity")
public class PlaceEntity {
    @Id
    @Column(name = "PlaceSearchId", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer placeSearchId;

    @Column(name = "Name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String formatAdd;

    @Column(name = "Location_latitude", columnDefinition = "DECIMAL(15,13)", nullable = false)
    private Double locationLat;

    @Column(name = "Location_longitude", columnDefinition = "DECIMAL(16,13)", nullable = false)
    private Double locationLng;

    @Column(name = "NE_latitude", columnDefinition = "DECIMAL(15,13)", nullable = false)
    private Double viewportNeLat;

    @Column(name = "NE_longitude", columnDefinition = "DECIMAL(16,13)", nullable = false)
    private Double viewportNeLng;

    @Column(name = "SW_latitude", columnDefinition = "DECIMAL(15,13)", nullable = false)
    private Double viewportSwLat;

    @Column(name = "SW_longitude", columnDefinition = "DECIMAL(16,13)", nullable = false)
    private Double viewportSwLng;

    public Integer getPlaceSearchId() {
        return placeSearchId;
    }

    public void setPlaceSearchId(Integer placeSearchId) {
        this.placeSearchId = placeSearchId;
    }

    public String getFormatAdd() {
        return formatAdd;
    }

    public void setFormatAdd(String formatAdd) {
        this.formatAdd = formatAdd;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(Double locationLat) {
        this.locationLat = locationLat;
    }

    public Double getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(Double locationLng) {
        this.locationLng = locationLng;
    }

    public Double getViewportNeLat() {
        return viewportNeLat;
    }

    public void setViewportNeLat(Double viewportNeLat) {
        this.viewportNeLat = viewportNeLat;
    }

    public Double getViewportNeLng() {
        return viewportNeLng;
    }

    public void setViewportNeLng(Double viewportNeLng) {
        this.viewportNeLng = viewportNeLng;
    }

    public Double getViewportSwLat() {
        return viewportSwLat;
    }

    public void setViewportSwLat(Double viewportSwLat) {
        this.viewportSwLat = viewportSwLat;
    }

    public Double getViewportSwLng() {
        return viewportSwLng;
    }

    public void setViewportSwLng(Double viewportSwLng) {
        this.viewportSwLng = viewportSwLng;
    }

    @Override
    public String toString() {
        return "PlaceEntity{" +
                "placeSearchId=" + placeSearchId +
                ", formatAdd='" + formatAdd + '\'' +
                ", locationLat=" + locationLat +
                ", locationLng=" + locationLng +
                ", viewportNeLat=" + viewportNeLat +
                ", viewportNeLng=" + viewportNeLng +
                ", viewportSwLat=" + viewportSwLat +
                ", viewportSwLng=" + viewportSwLng +
                '}';
    }
}
