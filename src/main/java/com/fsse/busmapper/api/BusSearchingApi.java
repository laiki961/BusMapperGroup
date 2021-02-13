package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BusSearchingApi {
    @Autowired
    private NwfbExtService nwfbExtService;

    @GetMapping("/getBusStopInfo/{stop_id}")
    public CtbStopResponseExtDto getBusStopInfo(@PathVariable("stop_id") String stopId){
        CtbStopResponseExtDto dto = nwfbExtService.getBusStopInfo(stopId);
        return dto;
    }

    @GetMapping("/getRouteStop/{route}/{direction}")
    public CtbRouteStopResponseExtDto getRouteStopForSpecificBus(
            @PathVariable("route") String route,
            @PathVariable("direction") String dir){
        CtbRouteStopResponseExtDto dto = nwfbExtService.getRouteStopForSpecificBus(route, dir);
        return dto;
    }

    @GetMapping("/getRoute/{route}")
    public CtbRouteResponseExtDto getRoute(@PathVariable("route") String route){
        CtbRouteResponseExtDto dto = nwfbExtService.getBusOriNDest(route);
        return dto;
    }






    //API 1: Fetch data from data source
//    @PutMapping("/fetchdata")
//    public FetchDataResponseDto fetchData(){
//        // need what data first?
//        // routestop -> stop -> route
//    }
}
