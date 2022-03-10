package com.mmk.sms.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author: Nathan
 */
public class SMSDomainTest {

    SMSDomain smsDomain = SMSDomain.builder().to("123456").from("654321").build();
    SMSDomain smsDomain1 = SMSDomain.builder().to("123456423546").from("65432112345").build();

    @Test
    public void smsDomainTest_HappyPath(){
        assertEquals("123456", smsDomain.getTo());
        assertEquals("654321", smsDomain.getFrom());
    }

    @Test
    public void accountTest_UnhappyPath(){
        assertNotEquals("123456", smsDomain1.getFrom());
    }
}
