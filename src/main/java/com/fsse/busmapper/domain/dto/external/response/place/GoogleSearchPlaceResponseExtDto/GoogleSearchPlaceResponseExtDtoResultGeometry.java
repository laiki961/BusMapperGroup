package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

public class GoogleSearchPlaceResponseExtDtoResultGeometry {
    private GoogleSearchPlaceResponseExtDtoResultGeometryLocation location;
    private GooglSearchPlaceNameResponseExtDtoResultGeometryViewport viewport;

    public GoogleSearchPlaceResponseExtDtoResultGeometryLocation getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceResponseExtDtoResultGeometryLocation location) {
        this.location = location;
    }

    public GooglSearchPlaceNameResponseExtDtoResultGeometryViewport getViewport() {
        return viewport;
    }

    public void setViewport(GooglSearchPlaceNameResponseExtDtoResultGeometryViewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResponseExtDtoResultGeometry{" +
                "location=" + location +
                ", viewport=" + viewport +
                '}';
    }
}
