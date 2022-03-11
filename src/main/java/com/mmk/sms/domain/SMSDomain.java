package com.mmk.sms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author: Nathan
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("inboundCache")
@ApiModel(description = "SMSDomain Request model")
public class SMSDomain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id", name = "id", required = true, value = "1")
    private String id;
    @Indexed
    @ApiModelProperty(notes = "from", name = "from", required = true, value = "234354657")
    private String from;
    @Indexed
    @ApiModelProperty(notes = "to", name = "to", required = true, value = "465766543234")
    private String to;

    @ApiModelProperty(notes = "text", name = "text", required = true, value = "Hello world!")
    private String text;
}
