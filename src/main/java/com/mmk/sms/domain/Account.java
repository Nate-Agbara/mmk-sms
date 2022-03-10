package com.mmk.sms.domain;

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
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String auth_id;
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "phone_number", joinColumns
            = @JoinColumn(name = "account_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id",
                    referencedColumnName = "id")
    )


    private List<PhoneNumber> phoneNumbers;

//    @Override
//    public String getAuthority() {
//        return username;
//    }
}
