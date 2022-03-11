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
@ApiModel(description = "LoginDto Request model")
public class LoginDto {

    @ApiModelProperty(notes = "username of the user", name = "username", required = true, value = "John")
    private String username;
    @ApiModelProperty(notes = "password of the user", name = "auth_id", required = true, value = "secret")
    private String auth_id;
}
