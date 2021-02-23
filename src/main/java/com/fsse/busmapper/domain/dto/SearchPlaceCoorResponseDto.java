package com.fsse.busmapper.domain.dto;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;

public class SearchPlaceCoorResponseDto {
    private String formatAdd;
    private Double locationLat;
    private Double locationLng;
    private Double viewportNeLat;
    private Double viewportNeLng;
    private Double viewportSwLat;
    private Double viewportSwLng;

    public SearchPlaceCoorResponseDto() {}

    public SearchPlaceCoorResponseDto(LocationNameDO locationNameDO) {
        this.formatAdd = locationNameDO.getFormatAdd();
        this.locationLat = locationNameDO.getLocationLat();
        this.locationLng = locationNameDO.getLocationLng();
        this.viewportNeLat = locationNameDO.getViewportNeLat();
        this.viewportNeLng = locationNameDO.getViewportNeLng();
        this.viewportSwLat = locationNameDO.getViewportSwLat();
        this.viewportSwLng = locationNameDO.getViewportSwLng();
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
        return "SearchPlaceCoorResponseDto{" +
                "formatAdd='" + formatAdd + '\'' +
                ", locationLat=" + locationLat +
                ", locationLng=" + locationLng +
                ", viewportNeLat=" + viewportNeLat +
                ", viewportNeLng=" + viewportNeLng +
                ", viewportSwLat=" + viewportSwLat +
                ", viewportSwLng=" + viewportSwLng +
                '}';
    }
}
