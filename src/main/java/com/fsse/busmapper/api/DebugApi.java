package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.SearchPlaceCoorResponseDto;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;
import com.fsse.busmapper.domain.dto.response.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.PlaceRepository;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.GoogleTurnCoortoNameService;
import com.fsse.busmapper.service.NwfbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/debug")
public class DebugApi {
    @Autowired
    private NwfbService nwfbService;
    @Autowired
    private GooglePlaceSearchService googlePlaceSearchService;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteStopRepository routeStopRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private GoogleTurnCoortoNameService googleTurnCoortoNameService;
    @Autowired
    private PlaceRepository placeRepository;
    private Logger logger = LoggerFactory.getLogger(DebugApi.class);

    @GetMapping("/load/all-route")
    public void loadAllRoutes() {
        nwfbService.loadAllRoutes();
    }

    @GetMapping("/load/all-routes-stop")
    public void loadRouteInAndOutboundStop () {
        List<RouteEntity> routeEntities = routeRepository.findAll();
        nwfbService.loadRouteInAndOutboundStop(routeEntities);
    }

    @GetMapping("/load/all-stop")
    public void loadAllStops() {
        logger.debug("Start loading [List<StopEntity>] from the database");
        List<StopEntity> stops = stopRepository.findAll();
        logger.debug("Done loading from database");
        nwfbService.loadAllStops();
    }

//    Final
//    @GetMapping("/load/all-buses-details")
//    public FetchDataFromCTBResponseDto loadAllBusData(){
//        return nwfbService.loadAllBusData();
//    }

    @GetMapping("/load/searchByPlaceId")
    public LocationNameDO searchByPlaceId(@RequestParam("placeId") String placeId) {
        return googleTurnCoortoNameService.locationNameDO(placeId);
    }

    @GetMapping("/search-bus-route/{origPlaceSearchId}/{destPlaceSearchId}")
    public void searchBusRoute(@PathVariable int origPlaceSearchId, @PathVariable int destPlaceSearchId){
        List<PlaceEntity> placeEntities = new ArrayList<>();

        PlaceEntity placeEntity0 = new PlaceEntity();
        placeEntity0.setPlaceSearchId(0);
        placeEntity0.setFormatAdd("Tai Po Centre");
        placeEntity0.setLocationLat(40.714232);
        placeEntity0.setLoactionLng(-73.9612889);
        placeEntity0.setViewportNeLat(40.7155809802915);
        placeEntity0.setViewportNeLng(-73.9599399197085);
        placeEntity0.setViewportSwLat(40.7128830197085);
        placeEntity0.setViewportSwLng(-73.96263788029151);
        placeEntities.add(placeEntity0);

        PlaceEntity placeEntity1 = new PlaceEntity();
        placeEntity1.setPlaceSearchId(1);
        placeEntity1.setFormatAdd("Sai Ying Pun Station, Sai Ying Pun, Hong Kong");
        placeEntity1.setLocationLat(22.285533);
        placeEntity1.setLoactionLng(114.142733);
        placeEntity1.setViewportNeLat(22.2868819802915);
        placeEntity1.setViewportNeLng(114.1440819802915);
        placeEntity1.setViewportSwLat(22.2841840197085);
        placeEntity1.setViewportSwLng(114.1413840197085);
        placeEntities.add(placeEntity1);

        placeRepository.saveAll(placeEntities);

        googlePlaceSearchService.searchBusRoute(origPlaceSearchId, destPlaceSearchId);

    }
}
