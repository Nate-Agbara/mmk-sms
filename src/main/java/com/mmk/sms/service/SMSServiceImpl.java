package com.mmk.sms.service;

import com.mmk.sms.Dto.ErrorResponse;
import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.PhoneNumber;
import com.mmk.sms.repository.AccountsRepository;
import com.mmk.sms.repository.PhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Nathan
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SMSServiceImpl implements SMSService{

    private final AccountsRepository accountsRepository;

    private final PhoneNumberRepository phoneNumberRepository;

    /**
     * sendInboundSMS checks if the <to> phone number exist for the calling account.
     * input is cached in redis cache if the text message is STOP. Data in the cache is configured
     * for eviction after 4hrs. Configuration is done in RedisConfig class.
     * @param sms
     * @return Optional of phoneNumber
     */
    @Override
    @Cacheable(value = "inboundCache", key = "{#sms.from, #sms.to}",
            condition = "#sms.text.equals('STOP')")
    public Optional<PhoneNumber> sendInboundSMS(SMS sms){
        log.info("Inside sendInboundSMS");
        Optional<PhoneNumber> phoneNumber = Optional.empty();
        phoneNumber =phoneNumberRepository.findByNumber(sms.getTo());
        return phoneNumber;
    }

    /**
     * sendOutboundSMS checks if the <from> phonenumber exist for the calling account
     * @param sms
     * @return Optional of phoneNumber
     */
    @Override
    public Optional<PhoneNumber> sendOutboundSMS(SMS sms){
        log.info("Inside sendOutboundSMS");
        Optional<PhoneNumber> phoneNumber = Optional.empty();
        phoneNumber =phoneNumberRepository.findByNumber(sms.getFrom());
        return phoneNumber;
    }

    /**
     * Custom input validation
     * @param to
     * @param from
     * @param text
     * @return
     */
    public ResponseEntity<?> validateInput(String to, String from, String text){
        log.info("validating input...");
        if((to == null || to.equals("")) ){
            log.info("to parameter is missing");
            return new ResponseEntity<>(ErrorResponse.builder().error("<to> parameter missing").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        if(from == null || from.equals("")){
            log.info("from parameter is missing");
            return new ResponseEntity<>(ErrorResponse.builder().error("<from> parameter missing").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        if((to.length() < 6 || to.length() > 16) ){
            log.info("to parameter is invalid");
            return new ResponseEntity<>(ErrorResponse.builder().error("<to> parameter invalid").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        if(from.length() < 6 || from.length() > 16){
            log.info("from parameter is invalid");
            return new ResponseEntity<>(ErrorResponse.builder().error("<from> parameter invalid").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        if(text == null || text.equals("") ){
            log.info("text parameter is missing");
            return new ResponseEntity<>(ErrorResponse.builder().error("<text> parameter missing").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        if((text.length() < 1 || text.length() > 120) ){
            log.info("text parameter is invalid");
            return new ResponseEntity<>(ErrorResponse.builder().error("<text> parameter invalid").message("").build(),
                    HttpStatus.BAD_REQUEST);
        }
        log.info("validation successful");
        return new ResponseEntity<>(ErrorResponse.builder().error("Exception").message("").build(),
                HttpStatus.OK);
    }
}
