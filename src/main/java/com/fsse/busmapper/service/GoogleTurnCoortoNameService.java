package com.fsse.busmapper.service;


import com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto.GoogleSearchPlaceNameResponseDto;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;

public interface GoogleTurnCoortoNameService {
    //load name from location
    GoogleSearchPlaceNameResponseExtDto loadLocationName(Double lat, Double lng);
    void searchPlaceCoor();
}
