package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "search_place_history")
public class SearchPlaceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer placeSearchId;
    @Column
    private String locationName;
    @Column
    private Double lat;
    @Column
    private Double lng;
    @Column
    private Double viewportNElat;
    @Column
    private Double viewportNElng;
    @Column
    private Double viewportSWlat;
    @Column
    private Double viewportSWlng;

    public Integer getPlaceSearchId() {
        return placeSearchId;
    }

    public void setPlaceSearchId(Integer placeSearchId) {
        this.placeSearchId = placeSearchId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    @Override
    public String toString() {
        return "locationNameEntity{" +
                "placeholderId=" + placeSearchId +
                ", locationName='" + locationName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
