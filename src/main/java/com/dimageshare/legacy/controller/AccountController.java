package com.dimageshare.legacy.controller;

import com.dimageshare.legacy.constant.UrlBaseApi;
import com.dimageshare.legacy.entity.rest.request.AccountLoginReq;
import com.dimageshare.legacy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/login")
    public ModelAndView login(@RequestBody AccountLoginReq accountLogin) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
