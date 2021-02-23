package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.SearchPlaceCoorResponseDto;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;
import com.fsse.busmapper.domain.dto.response.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.GoogleTurnCoortoNameService;
import com.fsse.busmapper.service.NwfbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/debug")
public class DebugApi {
    @Autowired
    private NwfbService nwfbService;

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteStopRepository routeStopRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private GoogleTurnCoortoNameService googleTurnCoortoNameService;

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

    //Final
//    @GetMapping("/load/all-buses-details")
//    public FetchDataFromCTBResponseDto loadAllBusData(){
//        return nwfbService.loadAllBusData();
//    }
    @GetMapping("/load/searchByPlaceId")
    public LocationNameDO searchByPlaceId(@RequestParam("placeId") String placeId) {
        return googleTurnCoortoNameService.locationNameDO(placeId);
    }
}
