package com.mmk.sms.controller;

import com.mmk.sms.service.SMSService;
import com.mmk.sms.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;

/**
 * @author: Nathan
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private JwtRequestHelper jwtRequestHelper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService userAccountService;

    @Test
    public void signin() {
//        restTemplate.postForEntity("/fintech/users/signin", new LoginDto("admin",
//                "myPass"), Void.class);
//        verify(this.service).signin("admin","myPass");
    }
}
