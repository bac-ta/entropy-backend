package com.demo.webapp.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum GenderType {
    MALE(0, "MALE"),
    FEMALE(1, "FEMALE"),
    OTHER(2, "OTHER");
    @Getter
    private int value;
    @Getter
    private String name;

    GenderType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static GenderType findByValue(int value) {
        return Arrays.stream(GenderType.values())
                .filter(genderType -> genderType.getValue() == value)
                .findFirst().orElse(null);
    }
}
