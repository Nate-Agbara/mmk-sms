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
public class LoginDto {

    private String username;
    private String auth_id;
}
