package com.mmk.sms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmk.sms.Dto.SMS;
import com.mmk.sms.service.SMSService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: Nathan
 */
@SpringBootTest
@AutoConfigureMockMvc
public class InboundControllerTest {

    @Autowired
    private JwtRequestHelper jwtRequestHelper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SMSService smsService;

    @Test
    void testSendInboundSMS() throws Exception {
//        //given
//        SMS sms = SMS.builder().from("4924195509198").to("4924195509199").text("Hello world!").build();
//        //when //then
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/inbound/sms")
//                        .content(asJsonString(sms))
//                        .headers(jwtRequestHelper.withRole("4924195509198"))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
