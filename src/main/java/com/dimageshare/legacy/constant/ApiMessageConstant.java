package com.dimageshare.legacy.constant;

/**
 * @author bac-ta
 */
public class ApiMessageConstant {
    public static final String LOGIN_SUCCESS = "Login in successful";
    public static final String LOGIN_ERROR = "Login in error";
    public static final String INVALID_JWT_SIGNATURE = "Invalid jwt signature";
    public static final String INVALID_JWT_TOKEN = "Invalid jwt token";
    public static final String EXPIRED_JWT_TOKEN = "Invalid jwt token";
    public static final String UNSUPPORT_JWT_TOKEN = "Unsupport jwt token";
    public static final String JWT_CLAIMS_EMPTY = "JWT claims string is empty";
    public static final String USER_CREATE_SUCCESSFUL = "User create successful";
    public static final String USER_CREATE_ERROR = "User create error";
    public static final String USER_EDIT_SUCCESSFUL = "User edit successful";
    public static final String USER_EDIT_ERROR = "User edit error";
    public static final String DATE_INPUT_FAILURE = "Date input failure";
    public static final String SAVE_ADMIN_ACCOUNT_SUCCESS = "Save admin account success";
    public static final String OBJECT_TYPE_NOT_VALID = "{} must be {}"; //ex User name must be string
    public static final String USER_TYPE_ARRAY_NOT_EMPTY = "User type array must not empty";
    public static final String USER_TYPE_ARRAY_NOT_VALID = "User type array must contain one in value 0,1,2 or 3";
}
