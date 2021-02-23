package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.LocationNameDOGeometry;

import java.util.List;

public class GoogleSearchPlaceNameResponseExtDtoResult {
    @JsonProperty("formatted_address")
    private String formatName;
    @JsonProperty("geometry")
    private GoogleSearchPlaceNameResponseExtDtoResultGeometry geometry;
    @JsonProperty("place_id")
    private String placeId;

}
