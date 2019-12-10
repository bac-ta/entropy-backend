package com.dimageshare.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum UserType {
    NORMAL(0, "NORMAL"),
    GUEST(1, "GUEST"),
    ADMINITRATOR(2, "ADMINITRATOR"),
    UNKNOWN(3, "UNKNOWN");
    @Getter
    private int code;

    private String description;

    UserType(int code, final String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static UserType findByCode(int code) {
        return Arrays.stream(UserType.values())
                .filter(userType -> userType.getCode() == code)
                .findFirst().orElse(UserType.UNKNOWN);
    }
}
