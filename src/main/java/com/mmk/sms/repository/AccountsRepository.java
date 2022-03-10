package com.mmk.sms.repository;

import com.mmk.sms.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Nathan
 */
@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

//    @Query(value = "select * from account where username = ?",
//            nativeQuery = true)
//    @Transactional
    Optional<Account> findByUsername(String userName);

}
