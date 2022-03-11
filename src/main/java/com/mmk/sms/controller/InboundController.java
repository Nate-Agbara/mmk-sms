package com.mmk.sms.controller;

import com.mmk.sms.Dto.ErrorResponse;
import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.PhoneNumber;
import com.mmk.sms.service.RedisService;
import com.mmk.sms.service.SMSService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Nathan
 */
@ApiOperation(value = "/inbound/sms", tags = "Inbound Controller")
@RestController
@RequestMapping("inbound/sms")
@RequiredArgsConstructor
public class InboundController {

    private final SMSService smsService;

    @ApiOperation(value = "SendInboundSMS", response = ErrorResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
    })
    @PostMapping
    public ResponseEntity<?> send( @RequestBody SMS sms){
        if(!smsService.validateInput(sms.getTo(), sms.getFrom(),
                sms.getText()).getStatusCode().is2xxSuccessful()){
            return smsService.validateInput(sms.getTo(), sms.getFrom(), sms.getText());
        }


        Optional<PhoneNumber> phoneNumber =  smsService.sendInboundSMS(sms);
        return phoneNumber.isPresent() ?
                new ResponseEntity<>(ErrorResponse.builder().error("").message("inbound sms ok").build(),
                        HttpStatus.OK) :
                new ResponseEntity<>(ErrorResponse.builder().error("to parameter not found").message("").build(),
                        HttpStatus.NOT_FOUND);
    }

    /**
     * Runtime exception handler for random unhandled exceptions
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public String RuntimeExceptionHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
