package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.SearchBusRoute;
import com.fsse.busmapper.domain.dto.external.response.BusEta.BusEtaResponseExtDto;
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
//        placeEntity0.setPlaceSearchId(0);
//        placeEntity0.setFormatAdd("Tai Po Centre");
//        placeEntity0.setLocationLat(40.714232);
//        placeEntity0.setLocationLng(-73.9612889);
//        placeEntity0.setViewportNelat(40.7155809802915);
//        placeEntity0.setViewportNeLng(-73.9599399197085);
//        placeEntity0.setViewportSwLat(40.7128830197085);
//        placeEntity0.setViewportSwLng(-73.96263788029151);
//        placeEntities.add(placeEntity0);
//        PlaceEntity placeEntity1 = new PlaceEntity();
//        placeEntity1.setPlaceSearchId(1);
//        placeEntity1.setFormatAdd("Sai Ying Pun Station, Sai Ying Pun, Hong Kong");
//        placeEntity1.setLocationLat(22.285533);
//        placeEntity1.setLocationLng(114.142733);
//        placeEntity1.setViewportNelat(22.2868819802915);
//        placeEntity1.setViewportNeLng(114.1440819802915);
//        placeEntity1.setViewportSwLat(22.2841840197085);
//        placeEntity1.setViewportSwLng(114.1413840197085);
//        placeEntities.add(placeEntity1);

        //Route No.1 //2403
//        PlaceEntity placeEntity2 = new PlaceEntity();
//        placeEntity2.setPlaceSearchId(2);
//        placeEntity2.setFormatAdd("Happy Valley (Upper)");
//        placeEntity2.setLocationLat(22.2644579);
//        placeEntity2.setLocationLng(114.1886403);
//        placeEntity2.setViewportNelat(22.2658068802915);
//        placeEntity2.setViewportNeLng(114.1899892802915);
//        placeEntity2.setViewportSwLat(22.2631089197085);
//        placeEntity2.setViewportSwLng(114.1872913197085);
//        placeEntities.add(placeEntity2);
//        //Route No.1 //2537
//        PlaceEntity placeEntity3 = new PlaceEntity();
//        placeEntity3.setPlaceSearchId(3);
//        placeEntity3.setFormatAdd("Bullock Lane, Wan Chai Road");
//        placeEntity3.setLocationLat(22.2767987920910);
//        placeEntity3.setLocationLng(114.1759725205300);
//        placeEntity3.setViewportNelat();
//        placeEntity3.setViewportNeLng();
//        placeEntity3.setViewportSwLat();
//        placeEntity3.setViewportSwLng();
//        placeEntities.add(placeEntity3);
//
//        placeRepository.saveAll(placeEntities);
//        logger.debug(placeEntities.toString()); //OK

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
    @GetMapping("/buseta/{oristop}/{route}")
    public BusEtaResponseExtDto test(String oriStop, String route){
        return nwfbExtService.busEta(oriStop,route);
    }
}
