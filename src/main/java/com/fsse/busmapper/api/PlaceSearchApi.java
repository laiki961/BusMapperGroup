package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.dto.internal.response.place.SearchBusRouteDto;
import com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace.GoogleSearchPlaceResponseDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/googleSearchPlace")
public class PlaceSearchApi {
    Logger logger = LoggerFactory.getLogger(PlaceSearchApi.class);

    @Autowired
    private GooglePlaceSearchService googlePlaceSearchService;
    @Autowired
    private PlaceRepository placeRepository;

//API 2
//    @GetMapping("/byPlaceLatLng/{lat}/{lng}")
//    public GoogleSearchPlaceResponseDto loadLocationName(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
//        return googleTurnCoortoNameService.loadLocationName(lat, lng);
//
//    }

    //API 3 DONE (DON'T TOUCH)
    @GetMapping("/byPlaceId/{placeId}")
    public GoogleSearchPlaceResponseDto searchPlaceCoorResponseDto(@PathVariable("placeId") String placeId) {
        Place placeDO = googlePlaceSearchService.googleSearchPlaceId(placeId);
        logger.debug("received 6: {}", placeDO );
        GoogleSearchPlaceResponseDto dto = new GoogleSearchPlaceResponseDto(placeDO);
        return dto;
    }

    //API 4
    @GetMapping("/search-bus-route/{origPlaceSearchId}/{destPlaceSearchId}")
    public SearchBusRouteDto searchBusRoute(@PathVariable int origPlaceSearchId, @PathVariable int destPlaceSearchId){
        List<PlaceEntity> placeEntities = new ArrayList<>();
        PlaceEntity placeEntity0 = new PlaceEntity();
        placeEntity0.setPlaceSearchId(0);
        placeEntity0.setFormatAdd("Tai Po Centre");
        placeEntity0.setLocationLat(40.714232);
        placeEntity0.setLocationLng(-73.9612889);
        placeEntity0.setViewportNelat(40.7155809802915);
        placeEntity0.setViewportNeLng(-73.9599399197085);
        placeEntity0.setViewportSwLat(40.7128830197085);
        placeEntity0.setViewportSwLng(-73.96263788029151);
        placeEntities.add(placeEntity0);
        PlaceEntity placeEntity1 = new PlaceEntity();
        placeEntity1.setPlaceSearchId(1);
        placeEntity1.setFormatAdd("Sai Ying Pun Station, Sai Ying Pun, Hong Kong");
        placeEntity1.setLocationLat(22.285533);
        placeEntity1.setLocationLng(114.142733);
        placeEntity1.setViewportNelat(22.2868819802915);
        placeEntity1.setViewportNeLng(114.1440819802915);
        placeEntity1.setViewportSwLat(22.2841840197085);
        placeEntity1.setViewportSwLng(114.1413840197085);
        placeEntities.add(placeEntity1);

        placeRepository.saveAll(placeEntities);

        SearchBusRouteDto dto = new SearchBusRouteDto();
        googlePlaceSearchService.
        return ;
//        googlePlaceSearchService.searchBusRoute(origPlaceSearchId, destPlaceSearchId);

    }
}
