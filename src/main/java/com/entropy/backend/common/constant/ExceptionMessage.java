package com.entropy.backend.common.constant;

/**
 * @author bac-ta
 */
public class ExceptionMessage {
    public static final String INVALID_JWT_SIGNATURE = "Invalid jwt signature";
    public static final String INVALID_JWT_TOKEN = "Invalid jwt token";
    public static final String EXPIRED_JWT_TOKEN = "Out of expired jwt token";
    public static final String UNSUPPORT_JWT_TOKEN = "Unsupport jwt token";
    public static final String EMAIL_NOT_FOUND_FROM_PROVIDER = "Email not found from OAuth2 provider";
}
