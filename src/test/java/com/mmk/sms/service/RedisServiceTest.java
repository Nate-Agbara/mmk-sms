package com.mmk.sms.service;

import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.SMSDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Nathan
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    SMSDomain smsDomain = SMSDomain.builder().to("123456").from("654321").build();
    SMS sms = SMS.builder().id("1").to("123456").from("654321").build();

    @Test
    public void save(){
         redisService
                .save(sms);
         Optional<SMS> smsOptional = redisService
                 .findByFromAndTo(sms.getFrom(), sms.getTo());
        assertEquals(smsOptional.isEmpty(), true);
    }
}
