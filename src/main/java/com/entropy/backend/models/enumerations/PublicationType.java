package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum PublicationType {
    WAITING(0, "WAITING"),
    PUBLISH(1, "PUBLISH");
    @Getter
    private int value;
    @Getter
    private String name;

    PublicationType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static PublicationType findByValue(int value) {
        return Arrays.stream(PublicationType.values())
                .filter(publicationType -> publicationType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.PUBLISH_TYPE_INVALID));
    }
}
