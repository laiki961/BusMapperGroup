package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.dto.internal.response.place.GoogleSearchPlaceResponseDto;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/googleSearchPlace")
public class PlaceSearchApi {
    @Autowired
    private GooglePlaceSearchService googlePlaceSearchService;

//API 2
//    @GetMapping("/byPlaceLatLng/{lat}/{lng}")
//    public GoogleSearchPlaceResponseDto loadLocationName(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
//        return googleTurnCoortoNameService.loadLocationName(lat, lng);
//
//    }

//API 3
    @GetMapping("/byPlaceId/{placeId}")
    public GoogleSearchPlaceResponseDto searchPlaceCoorResponseDto(@PathVariable("placeId") String placeId) {
        Place placeDO = googlePlaceSearchService.googleSearchPlaceId(placeId);

        GoogleSearchPlaceResponseDto dto = new GoogleSearchPlaceResponseDto(placeDO);
        return dto;
    }
}
