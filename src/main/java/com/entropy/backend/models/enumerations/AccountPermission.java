package com.entropy.backend.models.enumerations;

/**
 * Enum defines account permission (VIEW, SAVE, DELETE)
 *
 * @author bac-ta
 * @see AccountPermission
 * @since 2021-06-24
 */
public enum AccountPermission {
    CLIENT_VIEW("client:view"),
    CLIENT_SAVE("client:save"),
    CLIENT_DELETE("client:delete"),
    ADMINISTRATOR_VIEW("administrator:view"),
    ADMINISTRATOR_SAVE("administrator:save"),
    ADMINISTRATOR_DELETE("administrator:delete");

    private final String permission;

    AccountPermission(final String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
