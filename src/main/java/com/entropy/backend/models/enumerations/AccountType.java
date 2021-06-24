package com.entropy.backend.models.enumerations;


import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum AccountType {
    CLIENT(1, "NORMAL"),
    ADMINISTRATOR(2, "ADMINISTRATOR");
    @Getter
    private final int value;
    @Getter
    private final String name;

    AccountType(int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public static AccountType findByValue(int value) {
        return Arrays.stream(AccountType.values())
                .filter(userType -> userType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.USER_TYPE_INVALID));
    }
}
