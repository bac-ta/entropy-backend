package com.entropy.backend.models.enumerations;

import com.entropy.backend.services.AuthenticationService;

/**
 * Enum provides account role permission that map
 *
 * @author bac-ta
 * @see AuthenticationService
 * @since 2021-06-10
 */
public enum PermissionType {
    ADMINISTRATOR_VIEW,
    ADMINISTRATOR_SAVE,
    ADMINISTRATOR_DELETE,
    USER_VIEW,
    USER_SAVE,
    USER_DELETE
}
