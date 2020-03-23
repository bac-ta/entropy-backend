package com.entropy.backend.enumeration;

import lombok.Getter;

import java.util.Arrays;

public enum PublishStype {
    WAITTING(0, "WAITTING"),
    PUBLISH(1, "PUBLISH");
    @Getter
    private int value;
    @Getter
    private String name;

    PublishStype(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static PublishStype findByValue(int value) {
        return Arrays.stream(PublishStype.values())
                .filter(publishType -> publishType.getValue() == value)
                .findFirst().orElse(null);
    }
}
