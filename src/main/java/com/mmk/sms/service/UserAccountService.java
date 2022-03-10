package com.mmk.sms.service;

import com.mmk.sms.domain.Account;

import java.util.List;
import java.util.Optional;

/**
 * @author: Nathan
 */
public interface UserAccountService {

    Optional<String> signin(String username, String password);

//    Optional<Account> signup(String username, String password, String firstName, String lastName);

    List<Account> getAll();
}
