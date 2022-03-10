package com.mmk.sms.Dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Nathan
 */
public class SMSTest {

    SMS sms = SMS.builder().from("4924195509198").to("4924195509199").build();

    @Test
    public void smsDtoTest(){
        assertEquals("4924195509198", sms.getFrom());
        assertEquals("4924195509199", sms.getTo());
    }
}
