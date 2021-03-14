package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.SearchBusRoute;
import com.fsse.busmapper.domain.dto.internal.response.place.SearchBusRouteDto;
import com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace.GoogleSearchPlaceResponseDto;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/googleSearchPlace")
public class PlaceSearchApi {
    Logger logger = LoggerFactory.getLogger(PlaceSearchApi.class);

    @Autowired
    private GooglePlaceSearchService googlePlaceSearchService;

    //API 2
    @GetMapping("/byPlaceLatLng/{lat}/{lng}")
    public GoogleSearchPlaceResponseDto loadLocationName(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
        Place placeDO = googlePlaceSearchService.googleSearchByLatLng(lat,lng);
        logger.debug("received 6: {}", placeDO );
        GoogleSearchPlaceResponseDto dto = new GoogleSearchPlaceResponseDto(placeDO);
        return dto;
    }

    //API 3
    @GetMapping("/byPlaceId/{placeId}")
    public GoogleSearchPlaceResponseDto searchPlaceCoorResponseDto(@PathVariable("placeId") String placeId) {
        Place placeDO = googlePlaceSearchService.googleSearchByPlaceId(placeId);
        logger.debug("received 6: {}", placeDO );
        return new GoogleSearchPlaceResponseDto(placeDO);
    }

    //API 4
    @GetMapping("/search-bus-route/{origPlaceSearchId}/{destPlaceSearchId}")
    public SearchBusRouteDto searchBusRoute(@PathVariable int origPlaceSearchId, @PathVariable int destPlaceSearchId){
        List<SearchBusRoute> busRouteDetails = googlePlaceSearchService.searchBusStopIdWithinRange(origPlaceSearchId, destPlaceSearchId);
        return new SearchBusRouteDto(busRouteDetails);
    }


}
