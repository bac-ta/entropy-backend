package com.entropy.backend.models.enumerations;

import com.entropy.backend.models.exceptions.EnumNotFoundException;
import com.entropy.backend.services.AuthenticationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Enum provides account role type, we've 2 types: ADMINISTRATOR, USER
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
@RequiredArgsConstructor
public enum RoleType {
    ADMINISTRATOR(1, "ADMINISTRATOR"),
    CLIENT(2, "CLIENT");
    @Getter
    private final int value;
    @Getter
    private final String name;

    public static RoleType findByName(String name) {
        return Arrays.stream(RoleType.values()).filter(roleType -> roleType.getName().equals(name))
                .findFirst().orElseThrow(() -> new EnumNotFoundException("Role type", name));
    }
}
