package org.sang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching //允许缓存
@EnableScheduling //开启定时任务
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
