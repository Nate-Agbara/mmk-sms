package com.mmk.sms.controller;

import com.mmk.sms.Dto.ErrorResponse;
import com.mmk.sms.Dto.LoginDto;
import com.mmk.sms.service.UserAccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@ApiOperation(value = "/users", tags = "Account Controller")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AccountController {

    private final UserAccountService userAccountService;

    @ApiOperation(value = "signin", response = ErrorResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
    })
    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
        return userAccountService.signin(loginDto.getUsername(), loginDto.getAuth_id()).orElseThrow(()->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }
}
