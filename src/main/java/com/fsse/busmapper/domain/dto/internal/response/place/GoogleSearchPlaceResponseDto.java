package com.fsse.busmapper.domain.dto.internal.response.place;

import com.fsse.busmapper.domain.Place;

public class GoogleSearchPlaceResponseDto {
    private Integer placeSearchId; // from entity
    private String name;
    private GoogleSearchPlaceResponseDtoLocation location;
    private GoogleSearchPlaceResponseDtoViewport viewport;

    public GoogleSearchPlaceResponseDto() {}

    public GoogleSearchPlaceResponseDto (Place placeDO){
        this.placeSearchId = placeDO.getSearchPlaceId();
        GoogleSearchPlaceResponseDtoLocation location = new GoogleSearchPlaceResponseDtoLocation();
        location.setLat(getLocation().getLat());
        location.setLng(getLocation().getLng());
        this.location = location;

        GoogleSearchPlaceResponseDtoViewport viewport = new GoogleSearchPlaceResponseDtoViewport();
        //
        GoogleSearchPlaceResponseDtoViewportNe ne = new GoogleSearchPlaceResponseDtoViewportNe();
        ne.setLat(getViewport().getNe().getLat());
        ne.setLng(getViewport().getNe().getLng());
        viewport.setNe(ne);
        GoogleSearchPlaceResponseDtoViewportSw sw = new GoogleSearchPlaceResponseDtoViewportSw();
        sw.setLat(getViewport().getSw().getLat());
        sw.setLng(getViewport().getSw().getLng());
        viewport.setSw(sw);
        //
        this.viewport = viewport;
    }


    public Integer getPlaceSearchId() {
        return placeSearchId;
    }

    public void setPlaceSearchId(Integer placeSearchId) {
        this.placeSearchId = placeSearchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GoogleSearchPlaceResponseDtoLocation getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceResponseDtoLocation location) {
        this.location = location;
    }

    public GoogleSearchPlaceResponseDtoViewport getViewport() {
        return viewport;
    }

    public void setViewport(GoogleSearchPlaceResponseDtoViewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        return "GoogleSearchPlaceResponseDto{" +
                "placeSearchId=" + placeSearchId +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", viewport=" + viewport +
                '}';
    }
}
