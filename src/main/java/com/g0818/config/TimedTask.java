package com.g0818.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class TimedTask {

    @Scheduled(fixedDelay = 30000)
    public void taskTest(){
        System.out.println("执行了一次");
    }
}
