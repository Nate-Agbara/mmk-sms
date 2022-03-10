package com.mmk.sms.service;

import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.PhoneNumber;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * @author: Nathan
 */
public interface SMSService {

    Optional<PhoneNumber> sendInboundSMS(SMS sms);

    Optional<PhoneNumber> sendOutboundSMS(SMS sms);

    ResponseEntity<?> validateInput(String to, String from, String text);
}
