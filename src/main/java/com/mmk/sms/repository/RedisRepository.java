package com.mmk.sms.repository;

import com.mmk.sms.Dto.SMS;
import com.mmk.sms.domain.SMSDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: Nathan
 */
@Repository
public interface RedisRepository  extends CrudRepository<SMSDomain, String>{

    Optional<SMS> findByFromAndTo(String from, String to);

}
