package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GooglePlaceSearchService {
    //API 2


    //API 3
    Place googleSearchPlaceId(String placeId);

    //API 4
//    void searchBusRoute(int origPlaceSearchId, int destPlaceSearhId);
}
