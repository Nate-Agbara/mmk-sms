package com.mmk.sms.repository;

import com.mmk.sms.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author: Nathan
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountsRepositoryTest {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void savedAccountTest_returnsSavedAccount() {
        //given
        Account account = Account.builder().username("nathan").auth_id("secret").build();
        //when
        entityManager.persist(account);
        Optional<Account> accountOptional = accountsRepository.findByUsername(account.getUsername());

        //then
        assertThat(accountOptional.get().getUsername(), is("nathan"));
    }
}
