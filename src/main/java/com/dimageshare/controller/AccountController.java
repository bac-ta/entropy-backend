package com.dimageshare.controller;

import com.dimageshare.constant.UrlBaseApi;
import com.dimageshare.entity.rest.request.AccountLoginReq;
import com.dimageshare.entity.rest.response.AccountLoginResp;
import com.dimageshare.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bac-ta
 */
@Controller
@RequestMapping(UrlBaseApi.URL_BASE_ACCOUNT)
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AccountLoginReq accountLogin) {
        ModelAndView mv = new ModelAndView();
        AccountLoginResp resp = accountService.login(accountLogin);
        mv.addObject(resp);
        return "/login";
    }
}
