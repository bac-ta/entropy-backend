package com.entropy.backend.model.enumeration;


import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum UserType {
    NORMAL(0, "NORMAL"),
    GUEST(1, "GUEST"),
    ADMINITRATOR(2, "ADMINITRATOR");
    @Getter
    private int value;
    @Getter
    private String name;

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
