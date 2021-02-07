package com.entropy.backend.enumeration;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author bac-ta
 */
public enum GenderType {
    MALE(0, "MALE"),
    FEMALE(1, "FEMALE"),
    OTHER(2, "OTHER");
    @Getter
    private int value;
    @Getter
    private String name;

    GenderType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static GenderType findByValue(int value) {
        return Arrays.stream(GenderType.values())
                .filter(genderType -> genderType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.GENDER_TYPE_INVALID));
    }
}
