package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GoogleSearchPlaceCoorResultGeometryViewportResponseExtDto {
    @JsonProperty("northeast")
    private GoogleSearchPlaceCoorResultGeometryViewportNeResponseExtDto ne;
    @JsonProperty("southwest")
    private GoogleSearchPlaceCoorResultGeometryViewportSWResponseExtDto sw;

    public GoogleSearchPlaceCoorResultGeometryViewportNeResponseExtDto getNe() {
        return ne;
    }

    public void setNe(GoogleSearchPlaceCoorResultGeometryViewportNeResponseExtDto ne) {
        this.ne = ne;
    }

    public GoogleSearchPlaceCoorResultGeometryViewportSWResponseExtDto getSw() {
        return sw;
    }

    public void setSw(GoogleSearchPlaceCoorResultGeometryViewportSWResponseExtDto sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "GooglSearchPlaceNameResponseExtDtoResultGeometryViewport{" +
                "ne=" + ne +
                ", sw=" + sw +
                '}';
    }
}
