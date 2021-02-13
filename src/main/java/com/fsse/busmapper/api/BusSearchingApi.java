package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BusSearchingApi {
    @Autowired
    private NwfbExtService nwfbExtService;

    @GetMapping("/getBusStopInfo/stop_id")
    public CtbStopResponseExtDto getBusStopInfo(@RequestParam("stop_id") String stopId){
        CtbStopResponseExtDto dto = nwfbExtService.getBusStopInfo(stopId);
        return dto;
    }




    //API 1: Fetch data from data source
//    @PutMapping("/fetchdata")
//    public FetchDataResponseDto fetchData(){
//        // need what data first?
//        // routestop -> stop -> route
//    }
}
