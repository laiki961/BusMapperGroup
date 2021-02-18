package com.fsse.busmapper.api;

import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class DebugApi {
    @Autowired
    private NwfbService nwfbService;

//    @GetMapping("/load/all-bus")
//    public void loadAllBusData() {
//        nwfbService.loadAllBusData();
//    }

    @GetMapping("/load/specific-route-stop/{route}/{direction}")
    public void oadSpecificRouteStop(
            @PathVariable("route") String route,
            @PathVariable("direction") String dir) {
        nwfbService.loadAllBusData(route, dir);
    }

}
