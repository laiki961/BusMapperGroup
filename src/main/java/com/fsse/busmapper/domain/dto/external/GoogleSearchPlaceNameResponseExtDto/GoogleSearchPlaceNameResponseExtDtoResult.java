package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleSearchPlaceNameResponseExtDtoResult {
    @JsonProperty("formatted_address")
    private String formatAdd;
    @JsonProperty("geometry")
    private GoogleSearchPlaceNameResponseExtDtoResultGeometry geometry;
    @JsonProperty("place_id")
    private String placeId;

    public String getFormatAdd() {
        return formatAdd;
    }

    public void setFormatAdd(String formatAdd) {
        this.formatAdd = formatAdd;
    }

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

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResponseExtDtoResult{" +
                "formatName='" + formatAdd + '\'' +
                ", geometry=" + geometry +
                ", placeId='" + placeId + '\'' +
                '}';
    }
}
