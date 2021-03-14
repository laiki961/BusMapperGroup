package com.fsse.busmapper.service.external.impl;


import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.service.external.GooglePlaceSearchExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//API 2
@Service
public class GooglePlaceSearchExtServiceImpl implements GooglePlaceSearchExtService {
    private RestTemplate restTemplate = new RestTemplate();

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchExtServiceImpl.class);

    @Override
    public GoogleSearchPlaceLatLngResponseExtDto googlePlaceSearchByLatLng(Double lat, Double lng) {
        return restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng +
                        "&key=" + "AIzaSyCjCVCEaRCewdaqDQE6ocCPC1x_W-EsS-g",
                GoogleSearchPlaceLatLngResponseExtDto.class
        );
    }


    //API 3
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
