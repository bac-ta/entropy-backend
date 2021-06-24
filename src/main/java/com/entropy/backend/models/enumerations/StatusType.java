package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum StatusType {
    ON(1, "ON"),
    OFF(0, "OFF");
    @Getter
    private final int value;
    @Getter
    private final String name;

    StatusType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static StatusType findByValue(int value) {
        return Arrays.stream(StatusType.values())
                .filter(statusType -> statusType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.STATUS_TYPE_INVALID));
    }
}
