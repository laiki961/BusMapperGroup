package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto.GoogleSearchPlaceNameResponseDto;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;
import com.fsse.busmapper.domain.entity.SearchPlaceHistoryEntity;
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

    @Override
    public LocationNameDO locationNameDO(String placeId) {
        // Fetch place detail by searchInput from Google Search Place API
        LocationNameDO locationNameDO = googleTurnCoortoNameExtService.locationNameDO(placeId);

        // Convert ComplexPlace (DO) into PlaceEntity (Entity)
        SearchPlaceHistoryEntity entity = locationNameDO.toPlaceEntity();

        // Save the Entity into database
        entity = googlePlaceLocationNameRepository.save(entity);

        // Load the auto generated place ID into the ComplexPlace instance
        locationNameDO.setPlaceSearchId(entity.getPlaceSearchId());

        return locationNameDO;
    }
}
