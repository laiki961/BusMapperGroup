package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import com.fsse.busmapper.service.external.GooglePlaceSearchExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GooglePlaceSearchServiceImpl implements GooglePlaceSearchService {
    @Autowired
    private GooglePlaceSearchExtService googlePlaceSearchExtService;
    @Autowired
    private PlaceRepository placeRepository;

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchServiceImpl.class);

    public Place googleSearchLatLng(Double lat, Double lng){
        GoogleSearchPlaceLatLngResponseExtDto placeDto = googlePlaceSearchExtService.googlePlaceSearchByLatLng(lat, lng);
        logger.debug(placeDto.toString());

        Place placeDO = placeDto.toPlaceExtDo();
        PlaceEntity placeEntity = placeDO.toPlaceEntity();

        // Save the Entity into database
        placeEntity = placeRepository.save(placeEntity);

        // Load the auto generated place ID into the ??? instance
        placeEntity.setPlaceSearchId(placeEntity.getPlaceSearchId());

        return Place;
    }

    @Override
    public Place googleSearchPlaceId(String placeId) {
        // Fetch place detail by searchInput from Google Search Place API
        GoogleSearchPlaceIdResponseExtDto placeDto = googlePlaceSearchExtService.googlePlaceSearchByPlaceId(placeId);
        logger.debug(placeDto.toString());

        Place placeDO = placeDto.toPlaceExtDo();
        PlaceEntity placeEntity = placeDO.toPlaceEntity();

        // Save the Entity into database
        placeEntity = placeRepository.save(placeEntity);

        // Load the auto generated place ID into the ??? instance
        placeEntity.setPlaceSearchId(placeEntity.getPlaceSearchId());

        return placeDO;
    }
}
