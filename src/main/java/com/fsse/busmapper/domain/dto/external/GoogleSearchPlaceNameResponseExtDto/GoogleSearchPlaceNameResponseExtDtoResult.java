package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.LocationNameDOGeometry;

import java.util.List;

public class GoogleSearchPlaceNameResponseExtDtoResult {
    @JsonProperty("formatted_address")
    private String formatName;
    private GoogleSearchPlaceNameResponseExtDtoResultGeometry geometry;
    @JsonProperty("place_id")
    private String placeId;

    public GoogleSearchPlaceNameResponseExtDtoResultGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GoogleSearchPlaceNameResponseExtDtoResultGeometry geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResponseExtDtoResult{" +
                "formatName='" + formatName + '\'' +
                ", geometry=" + geometry +
                ", placeId='" + placeId + '\'' +
                '}';
    }

    public LocationNameDO toLocationNameDO(){
        LocationNameDO locationNameDO = new LocationNameDO();
        locationNameDO.setFormatName(formatName);
        locationNameDO.setPlaceId(placeId);
        locationNameDO.setGeometry(locationNameDO.getGeometry());
        return locationNameDO;
    }
}
