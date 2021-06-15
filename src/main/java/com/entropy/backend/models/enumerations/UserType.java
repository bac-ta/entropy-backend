package com.entropy.backend.models.enumerations;


import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum UserType {
    CLIENT(1, "NORMAL"),
    ADMINISTRATOR(2, "ADMINISTRATOR");
    @Getter
    private final int value;
    @Getter
    private final String name;

    UserType(int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static UserType findByValue(int value) {
        return Arrays.stream(UserType.values())
                .filter(userType -> userType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.USER_TYPE_INVALID));
    }
}
