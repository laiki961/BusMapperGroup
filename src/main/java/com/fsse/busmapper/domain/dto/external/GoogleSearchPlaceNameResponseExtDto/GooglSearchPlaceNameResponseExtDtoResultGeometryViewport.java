package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GooglSearchPlaceNameResponseExtDtoResultGeometryViewport {
    @JsonProperty("northeast")
    private GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportNE ne;
    @JsonProperty("southwest")
    private GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportSW sw;

    public GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportNE getNe() {
        return ne;
    }

    public void setNe(GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportNE ne) {
        this.ne = ne;
    }

    public GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportSW getSw() {
        return sw;
    }

    public void setSw(GoogleSearchPlaceNameResponseExtDtoResultGeometryViewportSW sw) {
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
