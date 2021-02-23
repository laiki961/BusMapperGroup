package com.fsse.busmapper.service;


import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto.GoogleSearchPlaceCoorResponseExtDto;

public interface GoogleTurnCoortoNameService {
    //load name from location
    GoogleSearchPlaceCoorResponseExtDto loadLocationName(Double lat, Double lng);
    void searchPlaceCoor();
}
