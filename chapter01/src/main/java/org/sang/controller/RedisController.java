package org.sang.controller;

import org.sang.model.RedisTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis")
    public void redis() {
        ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name", "胡歌");
        String name = ops1.get("name");
        System.out.println(name);

        ValueOperations<String, String> ops2 = stringRedisTemplate.opsForValue();
        RedisTable redisTable = new RedisTable();
        redisTable.setId(1);
        redisTable.setName("绿茶");
        redisTable.setAuthor("茉莉味");
        String test = String.valueOf(redisTable);
        ops2.set("redisTable", test);

        String redisTable1 = ops2.get("redisTable");
        System.out.println(redisTable1);
    }
}
