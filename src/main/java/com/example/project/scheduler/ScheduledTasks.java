package com.example.project.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

// NO PROPER FUNCTIONALITY YET cz ? //

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void showCurrentTime() {
        System.out.println("Fixed Rate Scheduler: Execution Time: " + dateFormat.format(new Date()));
    }
}