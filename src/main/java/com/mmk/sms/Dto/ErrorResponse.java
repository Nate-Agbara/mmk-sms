package com.mmk.sms.Dto;

import lombok.*;

/**
 * @author: Nathan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private String message;
    private String error;
}
