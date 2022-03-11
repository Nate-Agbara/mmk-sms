package com.mmk.sms.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author: Nathan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "ErrorResponse Request model")
public class ErrorResponse {

    @ApiModelProperty(notes = "Message from the API", name = "message", required = true, value = "successfully sent")
    private String message;
    @ApiModelProperty(notes = "error from the API", name = "error", required = true, value = "Invalid parameter")
    private String error;
}
