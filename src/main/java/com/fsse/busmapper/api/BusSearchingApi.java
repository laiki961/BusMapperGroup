package com.fsse.busmapper.api;

import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusSearchingApi {
    @Autowired
    private NwfbService nwfbService;


}
