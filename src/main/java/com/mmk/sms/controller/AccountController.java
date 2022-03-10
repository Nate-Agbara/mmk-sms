package com.mmk.sms.controller;

import com.mmk.sms.Dto.LoginDto;
import com.mmk.sms.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;

/**
 * @author: Nathan
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
        return userAccountService.signin(loginDto.getUsername(), loginDto.getAuth_id()).orElseThrow(()->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }
}
