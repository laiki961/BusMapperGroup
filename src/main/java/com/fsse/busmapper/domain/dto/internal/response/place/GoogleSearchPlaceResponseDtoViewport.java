package com.fsse.busmapper.domain.dto.internal.response.place;

public class GoogleSearchPlaceResponseDtoViewport {
    private GoogleSearchPlaceResponseDtoViewportNe ne;
    private GoogleSearchPlaceResponseDtoViewportSw sw;

    public GoogleSearchPlaceResponseDtoViewportNe getNe() {
        return ne;
    }

    public void setNe(GoogleSearchPlaceResponseDtoViewportNe ne) {
        this.ne = ne;
    }

    public GoogleSearchPlaceResponseDtoViewportSw getSw() {
        return sw;
    }

    public void setSw(GoogleSearchPlaceResponseDtoViewportSw sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceResponseDtoViewport{" +
                "ne=" + ne +
                ", sw=" + sw +
                '}';
    }
}

