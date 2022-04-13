package com.example.housekeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new  SimpleDateFormat("HH:mm:ss");

    private static int count = 0;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Scheduled(fixedDelay = 1500)
    public void reportCurrentTime(){
        String sql2 = "delete from history_str where clock < 1514736000 limit 100";
        int row = jdbcTemplate.update(sql2);
        count = count + row;

    }
    @Scheduled(fixedRate = 5000)
    public void reportRow(){
        log.info("{} rows has deleted. The time is now {}",count, dateFormat.format(new Date()));
    }
}
