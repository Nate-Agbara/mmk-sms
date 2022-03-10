package com.mmk.sms.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author: Nathan
 */
public class PhoneNumberTest {

    PhoneNumber phoneNumber = PhoneNumber.builder().number("4924195509198").account_id(1).build();
    PhoneNumber phoneNumber2 = PhoneNumber.builder().number("4924195509196").account_id(1).build();

    @Test
    public void accountTest_HappyPath(){
        assertEquals("4924195509198", phoneNumber.getNumber());
        assertEquals(1, phoneNumber.getAccount_id());
    }

    @Test
    public void accountTest_UnhappyPath(){
        assertNotEquals("4924195509198", phoneNumber2.getNumber());
    }

}
