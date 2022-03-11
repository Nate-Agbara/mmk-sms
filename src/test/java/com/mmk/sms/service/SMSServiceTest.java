package com.mmk.sms.service;

import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Nathan
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class SMSServiceTest {

    @MockBean
    SMSServiceImpl smsServiceimpl;

    SMS sms = SMS.builder().from("5678675434").to("12234534").text("Hello world!").build();

    @Test
    public void sendInboundSMS_Test(){
        Optional<PhoneNumber> phoneNumber = smsServiceimpl.sendInboundSMS(sms);
        assertEquals(phoneNumber.isEmpty(), true);
    }

    @Test
    public void sendOutboundSMS_Test(){
        Optional<PhoneNumber> phoneNumber = smsServiceimpl.sendOutboundSMS(sms);
        assertEquals(phoneNumber.isEmpty(), true);
    }

    @Test
    public void validateInput_Test(){
//        ResponseEntity<?> phoneNumber = null;
//        phoneNumber = smsServiceimpl
//                .validateInput(sms.getTo(), sms.getFrom(), sms.getText());
//        assertEquals(phoneNumber.getStatusCode().is2xxSuccessful(), true);
    }


}
