package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace.GoogleSearchPlaceResponseDto;

public interface GooglePlaceSearchExtService {
    GoogleSearchPlaceResponseDto loadLocationName(Double lat, Double lng);
    GoogleSearchPlaceIdResponseExtDto googlePlaceSearchByPlaceId(String placedId);
}
