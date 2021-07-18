package com.entropy.backend.models.enumerations;

import com.entropy.backend.models.exceptions.EnumNotFoundException;
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
    private final int value;
    @Getter
    private final String name;

    GenderType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static GenderType findByValue(int value) {
        return Arrays.stream(GenderType.values())
                .filter(genderType -> genderType.getValue() == value)
                .findFirst().orElseThrow(() -> new EnumNotFoundException("Gender type", value));
    }

    public static GenderType findByName(String name) {
        return Arrays.stream(GenderType.values()).filter(genderType -> genderType.getName().equals(name))
                .findFirst().orElse(null);
    }
}
