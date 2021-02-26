package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.SearchBusRoute;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.domain.dto.internal.response.place.SearchBusRouteDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import com.fsse.busmapper.service.external.GooglePlaceSearchExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GooglePlaceSearchServiceImpl implements GooglePlaceSearchService {
    @Autowired
    private GooglePlaceSearchExtService googlePlaceSearchExtService;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteStopRepository routeStopRepository;

    Logger logger = LoggerFactory.getLogger(GooglePlaceSearchServiceImpl.class);

    //API 2
    public Place googleSearchLatLng(Double lat, Double lng) {
        GoogleSearchPlaceLatLngResponseExtDto responseDto = googlePlaceSearchExtService.googlePlaceSearchByLatLng(lat, lng);
        Place placeDo = responseDto.toPlaceExtDo();
        PlaceEntity placeEntity = placeDo.toPlaceEntity();
        placeEntity = placeRepository.save(placeEntity);
        placeDo.setSearchPlaceId(placeEntity.getPlaceSearchId());
        return placeDo;
    }

    //API 3 (DONE Don't touch)
    @Override
    public Place googleSearchPlaceId(String placeId) {
        // Fetch place detail by searchInput from Google Search Place API
        GoogleSearchPlaceIdResponseExtDto placeDto = googlePlaceSearchExtService.googlePlaceSearchByPlaceId(placeId);
        logger.debug("received 1: {}", placeDto.toString()); //OK

        Place placeDO = placeDto.toPlaceExtDo(); //OK
        PlaceEntity placeEntity = placeDO.toPlaceEntity(); //OK

        // Save the Entity into database
        placeEntity = placeRepository.save(placeEntity);

        // Load the auto generated place ID into the ??? instance
        placeDO.setSearchPlaceId(placeEntity.getPlaceSearchId());
        logger.debug("received 4: {}", placeEntity);
        logger.debug("received 5: {}", placeDO);
        return placeDO;
    }

    //API 4
    public List<SearchBusRoute> searchBusStopIdWithinRange(int origPlaceSearchId, int destPlaceSearchId) {
//        List<StopEntity> stopEntities = stopRepository.findAll();
//        List<PlaceEntity> placeEntities = placeRepository.findAll();
        //Step 1.1: Find orig range
        logger.debug("calling searchBusStopIdWithinRange method");
        PlaceEntity origEntity = placeRepository.findByPlaceSearchId(origPlaceSearchId);
        logger.debug("(Orig) Lat: {}, orig Lng: {}", origEntity.getLocationLat(), origEntity.getLocationLng());
        //Step 1.1: Find dest range
        PlaceEntity destEntity = placeRepository.findByPlaceSearchId(destPlaceSearchId);
        logger.debug("(Dest) Lat: {}, orig Lng: {}", destEntity.getLocationLat(), destEntity.getLocationLng());

        //Step 1.2: StopId within orig range
        List<StopEntity> origStop = stopRepository.findByLatitudeBetweenAndLongitudeBetween(origEntity.getLocationLat() - 0.001, origEntity.getLocationLat() + 0.001, origEntity.getLocationLng() - 0.001, origEntity.getLocationLng() + 0.001);
        logger.debug("StopId in range(Orig): {}", origStop.toString());
        //Step 1.2: StopId within dest range
        List<StopEntity> destStop = stopRepository.findByLatitudeBetweenAndLongitudeBetween(destEntity.getLocationLat() - 0.001, destEntity.getLocationLat() + 0.001, destEntity.getLocationLng() - 0.001, destEntity.getLocationLng() + 0.001);
        logger.debug("StopId in range(Dest): {}", destStop.toString());
        ////^Found both stopId

        //Step 2: check if routeID form origStop exist in destStop
        List<RouteStopEntity> routeStopOrig = new ArrayList<>();
        for(int i=0; i<origStop.size();i++){
            routeStopOrig.addAll(routeStopRepository.findByStopEntity_StopId(origStop.get(i).getStopId()));
        }
        logger.debug("Route in range(Orig): {}", routeStopOrig.toString());
        List<RouteStopEntity> routeStopDest = new ArrayList<>();
        for(int i=0; i<destStop.size(); i++){
            routeStopDest.addAll(routeStopRepository.findByStopEntity_StopId(destStop.get(i).getStopId()));
        }
        logger.debug("Route in range(Dest): {}", routeStopDest.toString());

        List<RouteStopEntity> sameRouteIdInOrig = new ArrayList<>();
        List<RouteStopEntity> sameRouteIdInDest = new ArrayList<>();
        for (int i = 0; i < routeStopOrig.size(); i++) {
            for (int j = 0; j < routeStopDest.size(); j++) {
                //check (1)RouteID exist in Ori and Dest (2)both StopId if they are in the same direction
                if (routeStopOrig.get(i).getRouteEntity().getRouteId().equals(routeStopDest.get(j).getRouteEntity().getRouteId())
                    && routeStopOrig.get(i).getDir().equals(routeStopDest.get(j).getDir())
                    && routeStopOrig.get(i).getSeq()<routeStopDest.get(j).getSeq()){
                        sameRouteIdInOrig.add(routeStopOrig.get(i));
                        logger.debug("sameRouteIdInOrig: Added{}", routeStopOrig.get(i).toString());
                        sameRouteIdInDest.add(routeStopOrig.get(i));
                        logger.debug("sameRouteIdInDest: Added{}", routeStopDest.get(j).toString());
                }
            }
        }
        logger.debug("sameRouteIdInOrig: {}", sameRouteIdInOrig.toString());
        logger.debug("sameRouteIdInDest: {}", sameRouteIdInDest.toString());

        List<SearchBusRoute> busRouteDetails = new ArrayList<>();
        SearchBusRoute searchBusRoute = new SearchBusRoute();
        for(int i=0; i<sameRouteIdInOrig.size(); i++){
            searchBusRoute.setCo(sameRouteIdInOrig.get(i).getCo());
            searchBusRoute.setRoute(sameRouteIdInOrig.get(i).getRouteEntity().getRouteId());
            searchBusRoute.setDirection(sameRouteIdInOrig.get(i).getDir());
            searchBusRoute.setOrigName(sameRouteIdInOrig.get(i).getRouteEntity().getOrig());
            searchBusRoute.setOrigStop(sameRouteIdInOrig.get(i).getStopEntity().getStopId());
            for(int j=0; j<sameRouteIdInDest.size(); j++) {
                if(sameRouteIdInOrig.get(i).getRouteEntity().getRouteId().equals(sameRouteIdInDest.get(j).getRouteEntity().getRouteId())) {
                    searchBusRoute.setDestName(sameRouteIdInDest.get(j).getRouteEntity().getDest());
                    searchBusRoute.setDestStop(sameRouteIdInDest.get(j).getStopEntity().getStopId());
                }
            }
            busRouteDetails.add(searchBusRoute);
        }
        return busRouteDetails;


    }
}
