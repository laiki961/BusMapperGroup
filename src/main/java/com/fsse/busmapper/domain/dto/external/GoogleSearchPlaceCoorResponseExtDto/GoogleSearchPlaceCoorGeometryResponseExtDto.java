package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto;

public class GoogleSearchPlaceCoorGeometryResponseExtDto {
    private GoogleSearchPlaceCoorResultGeometryLocationExtDtoResponse location;
    private GoogleSearchPlaceCoorResultGeometryViewportResponseExtDto viewport;

    public GoogleSearchPlaceCoorResultGeometryLocationExtDtoResponse getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceCoorResultGeometryLocationExtDtoResponse location) {
        this.location = location;
    }

    public GoogleSearchPlaceCoorResultGeometryViewportResponseExtDto getViewport() {
        return viewport;
    }

    public void setViewport(GoogleSearchPlaceCoorResultGeometryViewportResponseExtDto viewport) {
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
