package com.entropy.backend.models.enumerations;

import com.entropy.backend.services.AuthenticationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum provides account role permission that map
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
@RequiredArgsConstructor
public enum PermissionType {
    ADMINISTRATOR_VIEW(1, "ADMINISTRATOR_VIEW"),
    ADMINISTRATOR_INSERT(2, "ADMINISTRATOR_INSERT"),
    ADMINISTRATOR_UPDATE(3, "ADMINISTRATOR_UPDATE"),
    ADMINISTRATOR_DELETE(4, "ADMINISTRATOR_DELETE"),
    CLIENT_VIEW(5, "CLIENT_VIEW"),
    CLIENT_INSERT(6, "CLIENT_INSERT"),
    CLIENT_UPDATE(7, "CLIENT_UPDATE"),
    CLIENT_DELETE(8, "CLIENT_DELETE");

    @Getter
    private final int value;
    @Getter
    private final String name;
}
