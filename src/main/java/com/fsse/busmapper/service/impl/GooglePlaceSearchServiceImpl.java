package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.service.GooglePlaceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GooglePlaceSearchServiceImpl implements GooglePlaceSearchService {
    @Autowired
    PlaceRepository placeRepository;

    @Override
    public List<OriStop>(){

    }

    public List<DestStop>(){
        
    }

    @Override
    public void searchBusRoute(int origPlaceSearchId, int destPlaceSearchId) {
        List<PlaceEntity> placeEntities = placeRepository.findAll();

        for(int i=0; i<placeEntities.size(); i++){
            if(placeEntities.get(i).getPlaceSearchId().equals(origPlaceSearchId)){
                ///
                double searchRangeLatPos = placeEntities.get(i).getLocationLat() + 0.001;
                double searchRangeLatNeg = placeEntities.get(i).getLocationLat() - 0.001;

                double searchRangeLngPos = placeEntities.get(i).getLocationLng() + 0.001;
                double searchRangeLngNeg = placeEntities.get(i).getLocationLng() - 0.001;

               if(searchRangeLatPos <= placeEntities.get(i).getLocationLat() && searchRangeLatNeg >= placeEntities.get(i).getLocationLat()
               && searchRangeLngPos <= placeEntities.get(i).getLocationLng() && searchRangeLngNeg >= placeEntities.get(i).getLocationLng()){

               }

            }
        }

        for(int i=0; i<placeEntities.size(); i++){
            if(placeEntities.get(i).getPlaceSearchId().equals(destPlaceSearchId)){

            }
        }
        //offset location lat+0.001
        //offset location lat-0.001

        //offset location lng+0.001
        //offset location lng-0.001
    }



}
