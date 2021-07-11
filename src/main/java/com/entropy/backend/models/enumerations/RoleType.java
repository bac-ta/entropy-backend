package com.entropy.backend.models.enumerations;

import com.entropy.backend.services.AuthenticationService;

/**
 * Enum provides account role type, we've 2 types: ADMINISTRATOR, USER
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
public enum RoleType {
    ADMINISTRATOR,
    USER
}
