package com.mmk.sms.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SMS {

    @JsonIgnore
    private String id;
    @NotEmpty
    @Size(min = 6, max = 16)
    private String from;

    @NotEmpty
    @Size(min = 6, max = 16)
    private String to;

    @NotEmpty(message = "text cannot be empty")
    @Size(min = 1, max = 120, message = "invalid text")
    private String text;
}
