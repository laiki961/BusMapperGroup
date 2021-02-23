package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto.GoogleSearchPlaceNameResponseDto;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;
import com.fsse.busmapper.repository.GooglePlaceLocationNameRepository;
import com.fsse.busmapper.service.GoogleTurnCoortoNameService;
import com.fsse.busmapper.service.external.GoogleTurnCoortoNameExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleTurnCoortoNameImpl implements GoogleTurnCoortoNameService {
    @Autowired
    private GoogleTurnCoortoNameExtService googleTurnCoortoNameExtService;
    @Autowired
    private GooglePlaceLocationNameRepository googlePlaceLocationNameRepository;

    public GoogleSearchPlaceNameResponseExtDto loadLocationName(Double lat, Double lng){
        //link with external service(turn dto to do)
        //convert to DO to entity
        //save entity to repository

        return googleTurnCoortoNameExtService.loadLocationName(lat, lng);
    }
    public void searchPlaceCoor(){
        //todo
    }
}
