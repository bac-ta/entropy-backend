package com.entropy.backend.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum CategoryType {
    DEVOPS(0, "DEVOPS"),
    JAVA(1, "JAVA"),
    JAVASCRIPT(2, "JAVASCRIPT"),
    PYTHON(3, "PYTHON");
    @Getter
    private int value;
    @Getter
    private String name;

    CategoryType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static CategoryType findByValue(int value) {
        return Arrays.stream(CategoryType.values())
                .filter(categoryType -> categoryType.getValue() == value)
                .findFirst().orElse(null);
    }
}
