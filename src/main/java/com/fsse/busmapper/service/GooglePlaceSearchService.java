package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.entity.PlaceEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GooglePlaceSearchService {
    void searchBusRoute(int origPlaceSearchId, int destPlaceSearchId);
}
