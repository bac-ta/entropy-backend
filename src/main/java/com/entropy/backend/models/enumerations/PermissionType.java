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
    ADMINISTRATOR_INSERT(2, "administrator:insert"),
    ADMINISTRATOR_UPDATE(3, "administrator:update"),
    ADMINISTRATOR_DELETE(4, "administrator:delete"),
    CLIENT_VIEW(5, "client:view"),
    CLIENT_INSERT(6, "client:insert"),
    CLIENT_UPDATE(7, "client:update"),
    CLIENT_DELETE(8, "client:delete");

    @Getter
    private final int value;
    @Getter
    private final String name;

    PermissionType(int value, final String name) {
        this.value = value;
        this.name = name;
    }
}
