package com.dimageshare.controller;

import com.dimageshare.constant.UrlBaseApi;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UrlBaseApi.URL_BASE_USER)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController {
}
