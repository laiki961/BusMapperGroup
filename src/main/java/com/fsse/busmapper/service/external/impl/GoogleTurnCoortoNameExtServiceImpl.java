package com.fsse.busmapper.service.external.impl;


import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;
import com.fsse.busmapper.service.external.GoogleTurnCoortoNameExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleTurnCoortoNameExtServiceImpl implements GoogleTurnCoortoNameExtService {
    private RestTemplate restTemplate = new RestTemplate();

    Logger logger = LoggerFactory.getLogger(GoogleTurnCoortoNameExtServiceImpl.class);

    @Override
    public GoogleSearchPlaceNameResponseExtDto loadLocationName(Double lat, Double lng) {
        GoogleSearchPlaceNameResponseExtDto response = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/geocode/json?latlng=" +
                        lat + "," + lng +
                        "&key=" + "AIzaSyCjCVCEaRCewdaqDQE6ocCPC1x_W-EsS-g",
                GoogleSearchPlaceNameResponseExtDto.class
        );
        logger.debug(response.toString());
        return response;
    }

    @Override
    public LocationNameDO locationNameDO(String placedId) {
        SearchPlaceCoorResponseExtDto searchPlaceCoorResponseExtDto = searchPlaceCoorResponseExtDto(placedId);
        return  searchPlaceCoorResponseExtDto.toSearchPlaceCoorDo();
    }


    public SearchPlaceCoorResponseExtDto searchPlaceCoorResponseExtDto(String placeId) {
        SearchPlaceCoorResponseExtDto response = restTemplate.getForObject(
                "https://maps.googleapis.com/maps/api/place/details/json?place_id=" +
                        placeId + "&key=AIzaSyBUhJeB80YLr4o1fC-q0r7_lzIJkQHldpg",
                SearchPlaceCoorResponseExtDto.class
        );
        logger.debug(response.toString());
        return response;
    }

}
