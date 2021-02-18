package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BusSearchingApi {
    @Autowired
    private NwfbExtService nwfbExtService;
    @Autowired
    private NwfbService nwfbService;
    @Autowired
    private StopRepository stopRepository;


    @GetMapping("/getBusStopInfo/{stop_id}")
    public CtbStopDataResponseExtDto getBusStopInfo(@PathVariable("stop_id") String stopId){
        List<Stop> stop = nwfbService.getBusStopInfo(stopId);
        Stop stop = nwfbExtService.saveStopElements(stopId);
        CtbStopDataResponseExtDto responseExtDto = new CtbStopDataResponseExtDto(stop);
        return responseExtDto;
    }

    @GetMapping("/getRouteStop/{route}/{direction}")
    public CtbRouteStopDataResponseExtDto getRouteStopForSpecificBus(
            @PathVariable("route") String route,
            @PathVariable("direction") String dir){
        List<RouteStop> routeStop = nwfbService.getRouteStopForSpecificBus(route, dir);
        CtbRouteStopDataResponseExtDto responseExtDto = new CtbRouteStopDataResponseExtDto(routeStop);
        return responseExtDto;
    }

    @GetMapping("/getRoute")
    public CtbRouteResponseExtDto getRoute(){
        List<Route> route = nwfbService.getBusOrigAndDest();
        CtbRouteResponseExtDto responseExtDto = new CtbRouteResponseExtDto();
        return responseExtDto;
    }

}
