package com.mmk.sms.service;

import com.mmk.sms.Dto.SMS;

import java.util.Optional;

/**
 * @author: Nathan
 */
public interface RedisService {

    Optional<SMS> findByFromAndTo(String from, String to);
    void save(SMS sms);
}
