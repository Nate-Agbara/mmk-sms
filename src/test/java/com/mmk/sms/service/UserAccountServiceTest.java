package com.mmk.sms.service;

import com.mmk.sms.domain.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * @author: Nathan
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class UserAccountServiceTest {

    @Autowired
    UserAccountService userService ;

    Account account = Account.builder().username("nathan").auth_id("secret").build();

    @Test
    public void signin(){
       Optional<String> stringOptional = userService
                .signin(account.getUsername(), account.getAuth_id());
       assertEquals(stringOptional.isEmpty(), true);
    }
}
