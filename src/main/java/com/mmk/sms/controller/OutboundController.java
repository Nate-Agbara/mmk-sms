package com.mmk.sms.controller;

import com.mmk.sms.Dto.ErrorResponse;
import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.PhoneNumber;
import com.mmk.sms.service.RedisService;
import com.mmk.sms.service.SMSService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.Optional;

/**
 * @author: Nathan
 */
@ApiOperation(value = "/Outbound/sms", tags = "Outbound Controller")
@RestController
@RequestMapping("outbound/sms")
@RequiredArgsConstructor
@Slf4j
public class OutboundController {

    private final SMSService smsService;

    private final RedisService redisService;

    private Bucket bucket = null;

    /**
     * Bucket4j implementation for limit throttling. This endpoint must be
     * called before the POST outbound/sms, of course after signing in first.
     * @return
     */
    @ApiOperation(value = "generate-token", response = ErrorResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
    })
    @GetMapping("/generate-token")
    public ResponseEntity<String> generateToken(){
        Refill refill = Refill.of(5, Duration.ofMinutes(1));
        bucket = Bucket.builder()
                .addLimit(Bandwidth.classic(5, refill))
                .build();
        return new ResponseEntity<String>("Generated Successfully: "+bucket.toString(), HttpStatus.OK);
    }

    @ApiOperation(value = "SendOutboundSMS", response = ErrorResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED"),
            @ApiResponse(code = 403, message = "FORBIDDEN"),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class)
    })
    @PostMapping
    public ResponseEntity<?> send(@Valid @RequestBody SMS sms){
        log.info("Inside outbound/sms");
        if(!bucket.tryConsume(1)){
            return new ResponseEntity<>(ErrorResponse.builder().error("limit reached for "+sms.getFrom())
                    .message("").build(), HttpStatus.FORBIDDEN);
        }
        if(!smsService.validateInput(sms.getTo(), sms.getFrom(),
                sms.getText()).getStatusCode().is2xxSuccessful()){
            return smsService.validateInput(sms.getTo(), sms.getFrom(), sms.getText());
        }
//            redisService.save(sms);
//            log.info("first, going to redis");
//            if(redisService.findByFromAndTo(sms.getFrom(), sms.getTo()).isPresent()){
//                return new ResponseEntity<>(ErrorResponse.builder().error("sms from "+sms.getFrom()+" " +
//                        "to "+sms.getTo()+" blocked by STOP request").message("").build(), HttpStatus.OK);
//            }

            log.info("out of redis and proceeding to send SMS");
            Optional<PhoneNumber> phoneNumber =  smsService.sendOutboundSMS(sms);
            return phoneNumber.isPresent() ?
                    new ResponseEntity<>(ErrorResponse.builder().error("").message("outbound sms ok").build(),
                            HttpStatus.OK) :
                    new ResponseEntity<>(ErrorResponse.builder().error("from parameter not found").message("").build(),
                            HttpStatus.NOT_FOUND);

    }

    /**
     * Runtime exception handler for random unhandled exceptions
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public String RuntimeExceptionHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
