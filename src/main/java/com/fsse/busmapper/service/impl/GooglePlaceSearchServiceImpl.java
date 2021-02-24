package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.repository.SearchBusRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import com.fsse.busmapper.service.external.GooglePlaceSearchExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GooglePlaceSearchServiceImpl implements GooglePlaceSearchService {
    @Autowired
    private GooglePlaceSearchExtService googlePlaceSearchExtService;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SearchBusRepository searchBusRepository;

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchServiceImpl.class);

//    public Place loadLocationName(Double lat, Double lng){
//        //link with external service(turn dto to do)
//        //convert to DO to entity
//        //save entity to repository
//
//        return googleTurnCoortoNameExtService.loadLocationName(lat, lng);
//    }

    //API 3 (DONE Don't touch)
    @Override
    public Place googleSearchPlaceId(String placeId) {
        // Fetch place detail by searchInput from Google Search Place API
        GoogleSearchPlaceIdResponseExtDto placeDto = googlePlaceSearchExtService.googlePlaceSearchByPlaceId(placeId);
        logger.debug("received 1: {}", placeDto.toString()); //OK

        Place placeDO = placeDto.toPlaceExtDo(); //OK
        PlaceEntity placeEntity = placeDO.toPlaceEntity(); //OK

        // Save the Entity into database
        placeEntity = placeRepository.save(placeEntity);

        // Load the auto generated place ID into the ??? instance
        placeDO.setSearchPlaceId(placeEntity.getPlaceSearchId());
        logger.debug("received 4: {}", placeEntity );
        logger.debug("received 5: {}", placeDO );
        return placeDO;
    }

    //API 4
    public void searchBusStopIdWithinRange(int origPlaceSearchId, int destPlaceSearchId){
        List<StopEntity> stopIdLat = searchBusRepository.findStopIdLatBetween();
    }
}
