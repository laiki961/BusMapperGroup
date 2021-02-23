package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDtoResultGeometry;
import com.fsse.busmapper.domain.entity.SearchPlaceHistoryEntity;

public class GoogleSearchPlaceNameResponseExtDO {

    private String formatAdd;
    private String placeId;
    private Double locationLat;
    private Double locationLng;
    private Double viewportNeLat;
    private Double viewportNeLng;
    private Double viewportSwLat;
    private Double viewportSwLng;

    public SearchPlaceHistoryEntity toPlaceEntity(){
        SearchPlaceHistoryEntity entity = new SearchPlaceHistoryEntity();
        entity.setFormatAdd(getFormatAdd());
        entity.setLocationLat(getLocationLat());
        entity.setLocationLng(getLocationLng());
        entity.setViewportNelat(getViewportNeLat());
        entity.setViewportNeLng(getViewportNeLng());
        entity.setViewportSwLat(getViewportSwLat());
        entity.setViewportSwLng(getViewportSwLng());
        return entity;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
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
}
