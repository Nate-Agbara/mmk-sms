package com.mmk.sms.service;

import com.mmk.sms.domain.Account;
import com.mmk.sms.repository.AccountsRepository;
import com.mmk.sms.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final AccountsRepository accountsRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    /**
     * Sign in a user into the application, with JWT-enabled authentication
     *
     * @param username  username
     * @param password  password
     * @return Optional of the Java Web Token, empty otherwise
     */
    public Optional<String> signin(String username, String password) {
        log.info("New account attempting to sign in");
        Optional<String> token = Optional.empty();
        Optional<Account> account = accountsRepository.findByUsername(username);
        if (account.isPresent()) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username, account.get().getPhoneNumbers()));
            } catch (AuthenticationException e){
                log.info("Log in failed for account {}", username);
            }
        }
        return token;
    }

    @Override
    public List<Account> getAll() {
        return accountsRepository.findAll();
    }

 }