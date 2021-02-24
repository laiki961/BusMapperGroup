package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.domain.dto.internal.response.place.GoogleSearchPlaceResponseDto;

public interface GooglePlaceSearchExtService {
    GoogleSearchPlaceLatLngResponseExtDto googlePlaceSearchByLatLng(Double lat, Double lng);
    GoogleSearchPlaceIdResponseExtDto googlePlaceSearchByPlaceId(String placedId);
}