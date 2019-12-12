package com.dimageshare.service;

import com.dimageshare.constant.ApiMessageConstant;
import com.dimageshare.entity.Account;
import com.dimageshare.entity.rest.request.AccountLoginReq;
import com.dimageshare.entity.rest.response.AccountLoginResp;
import com.dimageshare.repository.AdminAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author bac-ta
 */
@Service
public class AccountService {
    private AdminAccountRepository adminAccountRepository;

    @Autowired
    public AccountService(AdminAccountRepository adminAccountRepository) {
        this.adminAccountRepository = adminAccountRepository;
    }

    public AccountLoginResp login(AccountLoginReq accountLogin) {
        String usernameOrEmail = accountLogin.getUsernameOrEmail();
        String password = accountLogin.getPassword();
        Optional<Account> optionalAccount = adminAccountRepository.findByUsernameOrEmailAndPassword(usernameOrEmail, usernameOrEmail, password);
        if (optionalAccount.isPresent())
            return new AccountLoginResp(ApiMessageConstant.LOGIN_SUCCESS, HttpStatus.OK);
        return new AccountLoginResp(ApiMessageConstant.LOGIN_ERROR, HttpStatus.BAD_REQUEST);
    }

}
