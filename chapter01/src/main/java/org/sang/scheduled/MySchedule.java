package org.sang.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedule {
    @Scheduled(fixedDelay = 5000) //在当前任务执行结束5秒后开启另一个任务
    public void fixedDelay() {
        System.out.println("fixedDelay:" + new Date());
    }

    @Scheduled(fixedRate = 6000) //开始执行6秒后开启另一个定时任务
    public void fixedRate() {
        System.out.println("fixedRate:" + new Date());
    }

    @Scheduled(initialDelay = 5000, fixedRate = 6000) //首次执行延迟1秒，开始执行2秒后开启另一个定时任务
    public void initialDelay() {
        System.out.println("initialDelay:" + new Date());
    }

    @Scheduled(cron = "0 * * * * ?") //该任务每分钟执行一次
    public void cron() {
        System.out.println("cron:" + new Date());
    }
}
