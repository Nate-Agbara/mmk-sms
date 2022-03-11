//package com.mmk.sms.redisconfig;
//
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.data.redis.connection.RedisServer;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
///**
// * @author: Nathan
// */
//@TestConfiguration
//public class TestRedisConfiguration {
//
//    private RedisServer redisServer;
//
//    public TestRedisConfiguration(RedisProperties redisProperties) {
//        this.redisServer = new RedisServer(redisProperties.getRedisPort());
//    }
//
//    @PostConstruct
//    public void postConstruct() {
//        redisServer.start();
//    }
//
//    @PreDestroy
//    public void preDestroy() {
//        redisServer.stop();
//    }
//}
