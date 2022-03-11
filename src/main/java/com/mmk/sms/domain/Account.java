package com.mmk.sms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Nathan
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Account signup/signin Request model")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "id", name = "id", required = true, value = "1")
    private int id;
    @ApiModelProperty(notes = "auth_id of the user", name = "auth_id", required = true, value = "secret")
    private String auth_id;
    @ApiModelProperty(notes = "username of the user", name = "username", required = true, value = "John")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "phone_number", joinColumns
            = @JoinColumn(name = "account_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id",
                    referencedColumnName = "id")
    )

    @ApiModelProperty(notes = "phonenumbers of the user", name = "phonenumbers", required = true, value = "List")
    private List<PhoneNumber> phoneNumbers;

//    @Override
//    public String getAuthority() {
//        return username;
//    }
}
