package com.entropy.backend.enumeration;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum StatusType {
    ON(1, "ON"),
    OFF(0, "OFF");
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
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.STATUS_TYPE_INVALID));
    }
}
