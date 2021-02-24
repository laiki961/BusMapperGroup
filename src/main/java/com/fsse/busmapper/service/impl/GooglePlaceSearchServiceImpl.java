package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceIdResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto.GoogleSearchPlaceLatLngResponseExtDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.SearchBusRepository;
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
    private SearchBusRepository searchBusRepository;
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
    public Place googleSearchPlaceId(String placeId){
        // Fetch place detail by searchInput from Google Search Place API
        GoogleSearchPlaceIdResponseExtDto placeDto = googlePlaceSearchExtService.googlePlaceSearchByPlaceId(placeId);
        logger.debug("received 1: {}", placeDto.toString()); //OK

        Place placeDO = placeDto.toPlaceExtDo(); //OK
        PlaceEntity placeEntity = placeDO.toPlaceEntity(); //OK

        // Save the Entity into database
        placeEntity = placeRepository.save(placeEntity);

        // Load the auto generated place ID into the ??? instance
        placeDO.setSearchPlaceId(placeEntity.getPlaceSearchId());
        logger.debug("received 4: {}", placeEntity );
        logger.debug("received 5: {}", placeDO );
        return placeDO;
    }

    //API 4
    public void searchBusStopIdWithinRange(int origPlaceSearchId, int destPlaceSearchId){
        List<StopEntity> stopEntities = stopRepository.findAll();

        Double origLocationLat = null, origLocationLng = null;
        Double destLocationLat = null, destLocationLng = null;

        List<PlaceEntity> placeEntities = placeRepository.findAll();
        //Step 1: use StopId to find its lat & lng
        for(int i=0; i<placeEntities.size(); i++){
            if(placeEntities.get(i).getPlaceSearchId().equals(origPlaceSearchId)){
                origLocationLat = placeEntities.get(i).getLocationLat();
                origLocationLng = placeEntities.get(i).getLocationLng();
                logger.debug("lat: {}, lng: {}", origLocationLat,origLocationLng);
                break;
            }
        }
        List<StopEntity> origSameStopId = searchBusRepository.findByLatitudeBetweenAndLongitudeBetween(origLocationLat-0.001, origLocationLat+0.001, origLocationLng-0.001, origLocationLng+0.001 );
        logger.debug("StopId in range(Orig): {}", origSameStopId.toString());
        for(int i=0; i<placeEntities.size(); i++){
            if(placeEntities.get(i).getPlaceSearchId().equals(destPlaceSearchId)){
                destLocationLat = placeEntities.get(i).getLocationLat();
                destLocationLng = placeEntities.get(i).getLocationLng();
                logger.debug("lat: {}, lng: {}", destLocationLat,destLocationLng);
                break;
            }
        }
        List<StopEntity> destSameStopId = searchBusRepository.findByLatitudeBetweenAndLongitudeBetween(destLocationLat-0.001, destLocationLat+0.001, destLocationLng-0.001, destLocationLng+0.001 );
        logger.debug("StopId in range(Dest): {}", destSameStopId.toString());
        //^Found both stopId

        // use stopId to find routeId  routeStop: stopId -> routes
        List<RouteStopEntity> routeStopEntities = routeStopRepository.findAll();
        List<String> origRouteId = new ArrayList<>();
        List<String> destRouteId = new ArrayList<>();
        for(int j=0; j<routeStopEntities.size(); j++) {
            for (int i = 0; i < origSameStopId.size(); i++) {
                // if true: use the stopId to find routeId
                //&& destSameStopId.get(i).getStopId().equals(routeStopEntities.get(j).getStopEntity().getStopId())
                if (origSameStopId.get(i).getStopId().equals(routeStopEntities.get(j).getStopEntity().getStopId())){
                    //How to use stopId to find routeId******

                    //save the routeId, so later can compare origRouteId and destRouteId
                    origRouteId.add();
                }
                logger.debug("RouteId in range(Orig): {}, Amount of route {}", origRouteId.toString(), origRouteId.size());
                if (destSameStopId.get(i).getStopId().equals(routeStopEntities.get(j).getStopEntity().getStopId())){
                    destRouteId.add();
                }
                logger.debug("RouteId in range(Dest): {}, Amount of route {}", destSameStopId.toString(), destRouteId.size());
            }
        }

        // need to find out if the routeId exists in Orig & Dest
        List<String> sameRouteId = new ArrayList<>();
        if(origRouteId.size()>=destRouteId.size()){
            for(int i=0; i<origRouteId.size(); i++){
                for(int j=0; j<destRouteId.size(); j++){
                    if(origRouteId.get(i).equals(destRouteId.get(j))){
                        sameRouteId.add(origRouteId.get(i));
                    }
                }
            }
        }else{
            for(int i=0; i<destRouteId.size(); i++){
                for(int j=0; j<origRouteId.size(); j++){
                    if(destRouteId.get(i).equals(origRouteId.get(j))){
                        sameRouteId.add(destRouteId.get(i));
                    }
                }
            }
        }
        
        //check route direction (direction -> routeStopEntity)

        //when inbound (routeEntity -> orig/dest; origPlaceSearchId ->routeStop -> )
        //when outbound

        //check seq (seq -> routeStopEntity)

    }
}
