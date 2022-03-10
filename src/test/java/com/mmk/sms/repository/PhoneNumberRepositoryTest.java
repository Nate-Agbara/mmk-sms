package com.mmk.sms.repository;

import com.mmk.sms.domain.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author: Nathan
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PhoneNumberRepositoryTest {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void savedPhoneNumberTest_returnsSavedPhoneNumber() {
        //given
//        PhoneNumber phoneNumber = PhoneNumber.builder().id(98).number("4924195509198").account_id(1).build();
//        PhoneNumber phoneNumber2 = PhoneNumber.builder().id(99).number("4924195509198").account_id(1).build();
//        //when
//        entityManager.persist(phoneNumber);
//        List<PhoneNumber> phoneNumberOptional = phoneNumberRepository.findAllById();
//
//        //then
//        assertThat(phoneNumberOptional.get().getNumber(), is("4924195509198"));
    }
}
