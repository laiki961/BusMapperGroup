package com.fsse.busmapper.api;

import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debug")
public class DebugApi {
    @Autowired
    private NwfbService nwfbService;

    @GetMapping("/load/all-bus")
    public void loadAllBusData() {
        nwfbService.loadAllBusData();
    }

    @GetMapping("/loadStop/{stopId}")
    public void loadStop(@PathVariable("stopId") String stopId) {

        //hard code stopID
        nwfbService.loadStop(stopId);
    }

}
