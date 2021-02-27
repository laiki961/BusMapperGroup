package com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace;

import com.fsse.busmapper.domain.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSearchPlaceResponseDto {
    Logger logger = LoggerFactory.getLogger(GoogleSearchPlaceResponseDto.class);

    private Integer placeSearchId; // from entity
    private String name;
    private GoogleSearchPlaceResponseDtoLocation location;
    private GoogleSearchPlaceResponseDtoViewport viewport;

    public GoogleSearchPlaceResponseDto() {}

    public GoogleSearchPlaceResponseDto (Place placeDO){
        this.placeSearchId = placeDO.getSearchPlaceId();
        logger.debug("received 7: {}", placeDO.getSearchPlaceId());

        this.name = placeDO.getFormatAdd();

        GoogleSearchPlaceResponseDtoLocation location = new GoogleSearchPlaceResponseDtoLocation();
        location.setLat(placeDO.getLocationLat());
        location.setLng(placeDO.getLocationLng());
        this.location = location;
        logger.debug("received 8: {}", this.location);

        GoogleSearchPlaceResponseDtoViewport viewport = new GoogleSearchPlaceResponseDtoViewport();
        //
        GoogleSearchPlaceResponseDtoViewportNe ne = new GoogleSearchPlaceResponseDtoViewportNe();
        ne.setLat(placeDO.getViewportNeLat());
        ne.setLng(placeDO.getViewportNeLng());
        viewport.setNe(ne);
        GoogleSearchPlaceResponseDtoViewportSw sw = new GoogleSearchPlaceResponseDtoViewportSw();
        sw.setLat(placeDO.getViewportSwLat());
        sw.setLng(placeDO.getViewportSwLng());
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
