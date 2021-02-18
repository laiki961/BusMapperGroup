package com.fsse.busmapper.api;

import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class DebugApi {
    @Autowired
    private NwfbService nwfbService;

    @GetMapping("/load/all-bus")
    public void loadAllBusData() {
        nwfbService.loadAllBusData();
    }
}
