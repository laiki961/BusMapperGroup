package com.fsse.busmapper.config;

import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ScheduledTaskConfig {
    @Autowired
    private NwfbService nwfbService;

    @Scheduled(cron = "0 0 0 * * ?",zone = "Asia/Hong Kong") //second,minute,hour,date,month,day of the week
    public void syncBusDataPerDay(){
        nwfbService.loadAllBusData();
    }
}
