package com.dimageshare.enumeration;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum AccountType {
    NORMAL(0, "NORMAL"),
    GUEST(1, "GUEST"),
    ADMINITRATOR(2, "ADMINITRATOR"),
    UNKNOWN(3, "UNKNOWN");
    @Getter
    private int code;

    private String description;

    AccountType(int code, final String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static AccountType findByCode(int code) {
        return Arrays.stream(AccountType.values())
                .filter(accountType -> accountType.getCode() == code)
                .findFirst().orElse(AccountType.UNKNOWN);
    }
}
