package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum PublishType {
    WAITING(0, "WAITING"),
    PUBLISH(1, "PUBLISH");
    @Getter
    private int value;
    @Getter
    private String name;

    PublishType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static PublishType findByValue(int value) {
        return Arrays.stream(PublishType.values())
                .filter(publishType -> publishType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.PUBLISH_TYPE_INVALID));
    }
}
