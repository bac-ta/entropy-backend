package com.entropy.backend.models.enumerations;

import com.entropy.backend.services.AuthenticationService;
import lombok.Getter;

/**
 * Enum provides account role permission that map
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
public enum PermissionType {
    ADMINISTRATOR_VIEW(1, "administrator:view"),
    ADMINISTRATOR_SAVE(2, "administrator:save"),
    ADMINISTRATOR_DELETE(3, "administrator:delete"),
    CLIENT_VIEW(4, "client:view"),
    CLIENT_SAVE(5, "client:save"),
    CLIENT_DELETE(6, "client:delete");

    @Getter
    private final int value;
    @Getter
    private final String name;

    PermissionType(int value, final String name) {
        this.value = value;
        this.name = name;
    }
}
