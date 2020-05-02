package com.entropy.backend.enumeration;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum SortType {
    ASC(0, "ASC"),
    DESC(1, "DESC");
    @Getter
    private int value;
    @Getter
    private String name;

    SortType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static SortType findByValue(int value) {
        return Arrays.stream(SortType.values())
                .filter(sortType -> sortType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.GENDER_TYPE_INVALID));
    }
}
