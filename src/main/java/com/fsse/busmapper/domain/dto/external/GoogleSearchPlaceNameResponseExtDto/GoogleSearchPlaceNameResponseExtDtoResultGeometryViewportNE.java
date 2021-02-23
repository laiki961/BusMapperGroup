package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fsse.busmapper.domain.LocationNameDOGeometryViewport;

public class GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportNE {
    private Double lat;
    private Double lng;

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
        return "GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportNE{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
    
}
