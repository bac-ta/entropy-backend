package com.entropy.backend.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum CategoryType {
    CONVERSE(0, "CONVERSE"),
    DEVOPS(1, "DEVOPS"),
    JAVA(2, "JAVA"),
    JAVASCRIPT(3, "JAVASCRIPT"),
    PYTHON(4, "PYTHON"),
    GO(5, "GO"),
    BIGDATA(6, "BIGDATA");
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
