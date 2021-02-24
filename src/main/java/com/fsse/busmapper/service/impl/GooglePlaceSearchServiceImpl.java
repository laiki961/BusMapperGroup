package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.repository.SearchBusRepository;
import com.fsse.busmapper.repository.StopRepository;
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
    @Autowired
    private StopRepository stopRepository;

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchServiceImpl.class);

    public Place googleSearchLatLng(Double lat, Double lng) {

        GoogleSearchPlaceLatLngResponseExtDto responseDto = googlePlaceSearchExtService.googlePlaceSearchByLatLng(lat, lng);

        Place placeDo = responseDto.toPlaceExtDo();

        PlaceEntity placeEntity = placeDo.toPlaceEntity();

        placeEntity = placeRepository.save(placeEntity);

        placeDo.setSearchPlaceId(placeEntity.getPlaceSearchId());

        return placeDo;
    }

    //API 3 (DONE Don't touch)
    @Override
    public Place googleSearchPlaceId(String placeId){
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
        List<StopEntity> stops = stopRepository.findAll();
        for (int i=0; i<stops.size(); i++){
        List<StopEntity> stopIdLat = searchBusRepository.findOrigStopIdLatBetween(stops.get(i).getLatitude() - 0.001 , stops.get(i).getLatitude()+ 0.001);
        List<StopEntity> stopIdLng = searchBusRepository.findOrigStopIdLngBetween(stops.get(i).getLongitude() - 0.001, stops.get(i).getLongitude() + 0.001);
        }
    }
}
