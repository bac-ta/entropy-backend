package com.dimageshare.enumeration;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum GenderType {
    MALE(0, "MALE"),
    FEMALE(1, "FEMALE"),
    OTHER(2, "OTHER"),
    UNKNOWN(3, "UNKNOWN");
    @Getter
    private int code;

    private String description;

    GenderType(int code, final String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static GenderType findByCode(int code) {
        return Arrays.stream(GenderType.values())
                .filter(genderType -> genderType.getCode() == code)
                .findFirst().orElse(GenderType.UNKNOWN);
    }
}
