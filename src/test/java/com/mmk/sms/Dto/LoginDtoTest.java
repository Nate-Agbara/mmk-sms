package com.mmk.sms.Dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Nathan
 */
public class LoginDtoTest {

    LoginDto loginDto = LoginDto.builder().username("mmk").auth_id("secret").build();

    @Test
    public void smsDtoTest(){
        assertEquals("mmk", loginDto.getUsername());
        assertEquals("secret", loginDto.getAuth_id());
    }
}
