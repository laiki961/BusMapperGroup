package com.fsse.busmapper.service.external.impl;


import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.internal.response.place.googleSearchPlace.GoogleSearchPlaceResponseDto;
import com.fsse.busmapper.service.external.GooglePlaceSearchExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//API 2 (not yet finished)
@Service
public class GooglePlaceSearchExtServiceImpl implements GooglePlaceSearchExtService {
    private RestTemplate restTemplate = new RestTemplate();

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchExtServiceImpl.class);

    @Override
    public GoogleSearchPlaceResponseDto loadLocationName(Double lat, Double lng) {
        GoogleSearchPlaceResponseDto response = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=" +
                        lat + "," + lng +
                        "&key=" + "AIzaSyCjCVCEaRCewdaqDQE6ocCPC1x_W-EsS-g",
                GoogleSearchPlaceResponseDto.class
        );
        logger.debug(response.toString());
        return response;
    }


    //API 3 DONE (Don't touch)
    @Override
    public GoogleSearchPlaceIdResponseExtDto googlePlaceSearchByPlaceId(String placeId) {
        GoogleSearchPlaceIdResponseExtDto googleSearchPlaceIdResponseExtDto = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/place/details/json?place_id=" +
                        placeId + "&key=AIzaSyBUhJeB80YLr4o1fC-q0r7_lzIJkQHldpg",
                GoogleSearchPlaceIdResponseExtDto.class
        );
        logger.debug(googleSearchPlaceIdResponseExtDto.toString());
        return  googleSearchPlaceIdResponseExtDto;
    }

}
