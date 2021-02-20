package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.service.NwfbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private Logger logger = LoggerFactory.getLogger(DebugApi.class);

//    @GetMapping("/load/all-bus")
//    public void loadAllBusData() {
//        nwfbService.loadAllBusData();
//    }

//    @GetMapping("/load/specific-route-stop")
//    public void loadSpecificRouteStop() {
//        RouteEntity route = new RouteEntity();
//        route.setRouteId("1");
//        route.setOrig("anything");
//        route.setDest("anything");
//        nwfbService.loadRouteDirectionStop(route, "inbound");
//    }

    @GetMapping("/load/all-routes")
    public void loadRouteInAndOutboundStop () {
        List<RouteEntity> routeEntities = routeRepository.findAll();
        nwfbService.loadRouteInAndOutboundStop(routeEntities);
    }

    @GetMapping("/load/all-stops")
    public void loadAllStops() {
        logger.debug("Start loading [List<RouteStopEntity>] from the database");
        List<RouteStopEntity> routeStops = routeStopRepository.findAll();
        logger.debug("Done loading from database");
        for(int i=0; i<routeStops.size(); i++) {
            nwfbService.loadAllStops(routeStops);
        }
    }

}
