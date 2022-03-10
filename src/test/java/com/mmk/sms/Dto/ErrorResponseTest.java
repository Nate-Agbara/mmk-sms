package com.mmk.sms.Dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: Nathan
 */
public class ErrorResponseTest {

    ErrorResponse errorResponse = ErrorResponse.builder().message("").error("invalid parameter").build();

    @Test
    public void errorResponseTest(){
        assertEquals("", errorResponse.getMessage());
        assertEquals("invalid parameter", errorResponse.getError());
    }
}
