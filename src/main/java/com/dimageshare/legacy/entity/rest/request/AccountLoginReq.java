package com.dimageshare.legacy.entity.rest.request;

import lombok.Data;

/**
 * @author bac-ta
 */
@Data
public class AccountLoginReq {
    private String usernameOrEmail;
    private String password;
}
