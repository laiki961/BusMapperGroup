package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GooglSearchPlaceNameResponseExtDtoResultGeometryViewport {
    @JsonProperty("northeast")
    private GoogleSearchPlaceResponseExtDtoResultGeometryViewportNE ne;
    @JsonProperty("southwest")
    private GoogleSearchPlaceResponseExtDtoResultGeometryViewportSW sw;

    public GoogleSearchPlaceResponseExtDtoResultGeometryViewportNE getNe() {
        return ne;
    }

    public void setNe(GoogleSearchPlaceResponseExtDtoResultGeometryViewportNE ne) {
        this.ne = ne;
    }

    public GoogleSearchPlaceResponseExtDtoResultGeometryViewportSW getSw() {
        return sw;
    }

    public void setSw(GoogleSearchPlaceResponseExtDtoResultGeometryViewportSW sw) {
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
