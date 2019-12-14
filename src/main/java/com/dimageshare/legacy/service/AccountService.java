package com.dimageshare.legacy.service;

import com.dimageshare.legacy.constant.ApiMessageConstant;
import com.dimageshare.legacy.entity.Account;
import com.dimageshare.legacy.entity.rest.request.AccountLoginReq;
import com.dimageshare.legacy.entity.rest.response.AccountLoginResp;
import com.dimageshare.legacy.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author bac-ta
 */
@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountLoginResp login(AccountLoginReq accountLogin) {
        String usernameOrEmail = accountLogin.getUsernameOrEmail();
        String password = accountLogin.getPassword();
        Optional<Account> optionalAccount = accountRepository.findByUsernameOrEmailAndPassword(usernameOrEmail, usernameOrEmail, password);
        if (optionalAccount.isPresent())
            return new AccountLoginResp(ApiMessageConstant.LOGIN_SUCCESS, HttpStatus.OK);
        return new AccountLoginResp(ApiMessageConstant.LOGIN_ERROR, HttpStatus.BAD_REQUEST);
    }

}
