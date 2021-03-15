package com.fsse.busmapper.config;

import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledTaskConfig {
    @Autowired
    private NwfbService nwfbService;

//    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
//    public void syncBusDataPerDay(){
//        nwfbService.loadAllBusData();
//    }

    @Scheduled(cron = "0 0 0 * * ?", zone = "Asia/Hong Kong")
    public void syncBusDataPerDay(){
        nwfbService.loadAllBusData();
    }

}
