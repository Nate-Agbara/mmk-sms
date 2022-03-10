package com.mmk.sms.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * @author: Nathan
 */
public class AccountTest {

    Account account = Account.builder().username("nathan").auth_id("secret").build();
    Account account2 = Account.builder().username("mike").auth_id("secretmike").build();

    @Test
    public void accountTest_HappyPath(){
        assertEquals("nathan", account.getUsername());
        assertEquals("secret", account.getAuth_id());
    }

    @Test
    public void accountTest_UnhappyPath(){
        assertNotEquals("secret", account2.getAuth_id());
    }
}
