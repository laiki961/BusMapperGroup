package com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto;

public class GoogleSearchPlaceNameResponseDto {
    private String name;
    private GoogleSearchPlaceNameResponseLocation location;
    private GoogleSearchPlaceNameResponseViewport viewport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoogleSearchPlaceNameResponseLocation getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceNameResponseLocation location) {
        this.location = location;
    }

    public GoogleSearchPlaceNameResponseViewport getViewport() {
        return viewport;
    }

    public void setViewport(GoogleSearchPlaceNameResponseViewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResopnseDto{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", viewport=" + viewport +
                '}';
    }
}
