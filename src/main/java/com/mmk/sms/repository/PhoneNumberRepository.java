package com.mmk.sms.repository;

import com.mmk.sms.domain.Account;
import com.mmk.sms.domain.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Nathan
 */
@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

    Optional<PhoneNumber> findByNumber(String to);

}
