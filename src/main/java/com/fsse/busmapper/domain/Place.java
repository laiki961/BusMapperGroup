package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.service.impl.GooglePlaceSearchServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Place {
    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchServiceImpl.class);

    private Integer searchPlaceId;
    private String formatAdd;
    private Double locationLat;
    private Double locationLng;
    private Double viewportNeLat;
    private Double viewportNeLng;
    private Double viewportSwLat;
    private Double viewportSwLng;

    public PlaceEntity toPlaceEntity(){
        PlaceEntity entity = new PlaceEntity();
        entity.setFormatAdd(getFormatAdd());
        entity.setLocationLat(getLocationLat());
        entity.setLocationLng(getLocationLng());
        entity.setViewportNelat(getViewportNeLat());
        entity.setViewportNeLng(getViewportNeLng());
        entity.setViewportSwLat(getViewportSwLat());
        entity.setViewportSwLng(getViewportSwLng());
        logger.debug("received 3: {}", entity );
        return entity;
    }

    public Integer getSearchPlaceId() {
        return searchPlaceId;
    }

    public void setSearchPlaceId(Integer searchPlaceId) {
        this.searchPlaceId = searchPlaceId;
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
        return "Place{" +
                "searchPlaceId='" + searchPlaceId + '\'' +
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
