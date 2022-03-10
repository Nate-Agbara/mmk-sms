package com.mmk.sms.service;

import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.SMSDomain;
import com.mmk.sms.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Nathan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RedisServiceImpl implements RedisService{

    private final RedisRepository redisRepository;

    @Override
    public void save(SMS sms){
        redisRepository.save(SMSDomain.builder().from(sms.getFrom()).to(sms.getTo()).build());
    }

    /**
     * findByFromAndTo checks if a key matching the pair of from and to has been cached
     * before for BLOCKING
     * @param from
     * @param to
     * @return
     */
    @Override
    public Optional<SMS> findByFromAndTo(String from, String to){
        log.info("Inside Redis findByFromAndTo");
        Optional<SMS> sms = Optional.empty();
        try {
            sms =Optional.of( redisRepository.findByFromAndTo(from, to).get());
        }catch (Exception e){
            e.printStackTrace();
        }

        sms.ifPresentOrElse(
                o -> log.info("findByFromAndTo from: {}, to: {}: response: {}", from, to, o),
                () -> log.info("findByFromAndTo from: {}, to: {}: null", from,to));

        return sms;
    }
}
