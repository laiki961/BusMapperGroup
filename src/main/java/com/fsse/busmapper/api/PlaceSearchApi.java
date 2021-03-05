package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.BusEtaExtDO;
import com.fsse.busmapper.domain.BusEtaIntDO;
import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.SearchBusRoute;
import com.fsse.busmapper.domain.dto.external.response.BusEta.BusEtaDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.BusEta.BusEtaResponseExtDto;
import com.fsse.busmapper.domain.dto.internal.response.BusEta.BusEtaResponseDto;
import com.fsse.busmapper.domain.dto.internal.response.place.SearchBusRouteDto;
import com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace.GoogleSearchPlaceResponseDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private NwfbService nwfbService;
    @Autowired
    private NwfbExtService nwfbExtService;

    //API 2 DONE (DON'T TOUCH)
    @GetMapping("/byPlaceLatLng/{lat}/{lng}")
    public GoogleSearchPlaceResponseDto loadLocationName(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
        Place placeDO = googlePlaceSearchService.googleSearchLatLng(lat,lng);
        logger.debug("received 6: {}", placeDO );
        GoogleSearchPlaceResponseDto dto = new GoogleSearchPlaceResponseDto(placeDO);
        return dto;
    }

    //API 3 DONE (DON'T TOUCH)
    @GetMapping("/byPlaceId/{placeId}")
    public GoogleSearchPlaceResponseDto searchPlaceCoorResponseDto(@PathVariable("placeId") String placeId) {
        Place placeDO = googlePlaceSearchService.googleSearchPlaceId(placeId);
        logger.debug("received 6: {}", placeDO );
        return new GoogleSearchPlaceResponseDto(placeDO);
    }

    //API 4
    @GetMapping("/search-bus-route/{origPlaceSearchId}/{destPlaceSearchId}")
    public SearchBusRouteDto searchBusRoute(@PathVariable int origPlaceSearchId, @PathVariable int destPlaceSearchId){
        List<PlaceEntity> placeEntities = new ArrayList<>();
        PlaceEntity placeEntity0 = new PlaceEntity();
        List<SearchBusRoute> busRouteDetails = googlePlaceSearchService.searchBusStopIdWithinRange(origPlaceSearchId, destPlaceSearchId);
        logger.debug("Finished API 4");
        return new SearchBusRouteDto(busRouteDetails);
    }
//      api 5
//    @GetMapping("/{route}/{dir}/{oriStop}/{destStop}")
//    public BusEtaResponseDto busEta(@PathVariable String route, @PathVariable String dir, @PathVariable String oriStop, @PathVariable String destStop){
//        BusEtaResponseDto result = busEtaResponseDto.toBusEtaDto(route,dir,oriStop,destStop);
//        return result;
//    }
    //pass this to nwfb service
    @GetMapping("/busEta/{route}/{dir}/{oriStop}/{destStop}")
    public BusEtaResponseDto busEta(@PathVariable String route, @PathVariable String dir, @PathVariable String oriStop, @PathVariable String destStop){
        BusEtaIntDO result = nwfbService.busEta(route,dir,oriStop,destStop);
        BusEtaResponseDto dto = new BusEtaResponseDto(result);
        return dto;
    }
}
