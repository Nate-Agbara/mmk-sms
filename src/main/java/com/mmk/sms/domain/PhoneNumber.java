package com.mmk.sms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: Nathan
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@RedisHash("PhoneNumber")
@ApiModel(description = "PhoneNumber model")
public class PhoneNumber implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "id", name = "id", required = true, value = "1")
    private int id;
    @ApiModelProperty(notes = "phoneNumber", name = "number", required = true, value = "23565456765")
    private String number;
    @ApiModelProperty(notes = "account_id", name = "account_id", required = true, value = "1")
    private int account_id;

    @Override
    public String getAuthority() {
        return number;
    }
}
