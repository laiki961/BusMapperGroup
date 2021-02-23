package com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto;

public class GoogleSearchPlaceNameResponseViewport {
    private GoogleSearchPlaceNameResponseViewportNW nw;
    private GoogleSearchPlaceNameResponseLocationSW sw;

    public GoogleSearchPlaceNameResponseViewportNW getNw() {
        return nw;
    }

    public void setNw(GoogleSearchPlaceNameResponseViewportNW nw) {
        this.nw = nw;
    }

    public GoogleSearchPlaceNameResponseLocationSW getSw() {
        return sw;
    }

    public void setSw(GoogleSearchPlaceNameResponseLocationSW sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceNameResponseViewport{" +
                "nw=" + nw +
                ", sw=" + sw +
                '}';
    }
}
