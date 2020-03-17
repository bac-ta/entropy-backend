package com.entropy.backend.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum StatusType {
    ON(0, "ON"),
    OFF(1, "OFF");
    @Getter
    private int value;
    @Getter
    private String name;

    StatusType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static StatusType findByValue(int value) {
        return Arrays.stream(StatusType.values())
                .filter(statusType -> statusType.getValue() == value)
                .findFirst().orElse(null);
    }
}
