package com.entropy.backend.constant;

/**
 * @author bac-ta
 */
public class APIMessage {
    public static final String PASSWORD_NOT_MATCH = "Password and confirm password not match";
    public static final String EMAIL_NOT_MATCH = "Email and confirm email not match";
    public static final String PASSWORD_NOT_BLANK = "Password must not blank";
    public static final String EMAIL_NOT_BLANK = "Email must not blank";
    public static final String FIRST_NAME_NOT_BLANK = "First name must not blank";
    public static final String LAST_NAME_NOT_BLANK = "Last name must not blank";
    public static final String CONFIRM_EMAIL_NOT_BLANK = "Confirm email must not blank";
    public static final String CONFIRM_PASSWORD_NOT_BLANK = "Confirm password must not blank";
    public static final String USER_TYPE_NOT_EMPTY = "User type must not empty";
    public static final String USER_NAME_NOT_BLANK = "User name must not blank";

    //Authenticate
    public static String RESOURCE_NOT_FOUND = "%s not found with %s : '%s'";
    public static String LOGIN_SUCCESSFUL = "Login successful";
    public static String ENDTRY_POINT_UNAUTHORIZED = "Responding with unauthorized error. Message - {}";

    //User
    public static String REGIST_USER_SUCCESSFUL = "Regist user succesful";
    public static String REGIST_USER_FAIL = "Regist user fail";

    //Post
    public static String POST_ID_INVALID = "Post id not valid";
    public static String CREATE_POST_FAIL = "Create post fail";
    public static String CREATE_POST_SUCCESSFUL = "Create post successful";
}
