package com.mmk.sms.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author: Nathan
 */
@Getter
@Setter
@Builder
@ApiModel(description = "SMS Request model")
public class SMS {

    @JsonIgnore
    @ApiModelProperty(notes = "Id of the user", name = "id", required = true, value = "1")
    private String id;
    @NotEmpty
    @ApiModelProperty(notes = "from phoneNumber", name = "from", required = true, value = "256767875654")
    @Size(min = 6, max = 16)
    private String from;

    @NotEmpty
    @Size(min = 6, max = 16)
    @ApiModelProperty(notes = "to phoneNumber", name = "to", required = true, value = "3235465787654")
    private String to;

    @NotEmpty(message = "text cannot be empty")
    @Size(min = 1, max = 120, message = "invalid text")
    @ApiModelProperty(notes = "text message", name = "text", required = true, value = "Hello World!")
    private String text;
}
