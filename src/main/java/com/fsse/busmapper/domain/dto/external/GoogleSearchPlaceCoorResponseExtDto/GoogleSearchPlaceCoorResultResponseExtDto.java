package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleSearchPlaceCoorResultResponseExtDto {
    @JsonProperty("formatted_address")
    private String formatAdd;
    @JsonProperty("geometry")
    private GoogleSearchPlaceCoorGeometryResponseExtDto geometry;
    @JsonProperty("place_id")
    private String placeId;

    public String getFormatAdd() {
        return formatAdd;
    }

    public void setFormatAdd(String formatAdd) {
        this.formatAdd = formatAdd;
    }

    public GoogleSearchPlaceCoorGeometryResponseExtDto getGeometry() {
        return geometry;
    }

    public void setGeometry(GoogleSearchPlaceCoorGeometryResponseExtDto geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResponseExtDtoResult{" +
                "formatName='" + formatAdd + '\'' +
                ", geometry=" + geometry +
                ", placeId='" + placeId + '\'' +
                '}';
    }
}
