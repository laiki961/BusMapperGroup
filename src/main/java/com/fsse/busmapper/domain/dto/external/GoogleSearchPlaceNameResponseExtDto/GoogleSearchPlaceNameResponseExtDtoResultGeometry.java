package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

public class GoogleSearchPlaceNameResponseExtDtoResultGeometry {
    private GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation location;
    private GooglSearchPlaceNameResponseExtDtoResultGeometryViewport viewport;

    public GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation location) {
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
