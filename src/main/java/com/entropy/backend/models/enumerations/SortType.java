package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum SortType {
    ASC(0, "ASC"),
    DESC(1, "DESC");
    @Getter
    private final int value;
    @Getter
    private final String name;

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
