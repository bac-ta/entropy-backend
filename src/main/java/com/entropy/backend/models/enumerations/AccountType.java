package com.entropy.backend.models.enumerations;


import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bac-ta
 * @since 2021-06-25
 */
public enum AccountType {
    CLIENT(1, Stream.of(AccountPermission.CLIENT_VIEW, AccountPermission.CLIENT_SAVE, AccountPermission.CLIENT_DELETE).collect(Collectors.toSet())),
    ADMINISTRATOR(2, Stream.of(AccountPermission.ADMINISTRATOR_VIEW, AccountPermission.ADMINISTRATOR_SAVE, AccountPermission.ADMINISTRATOR_DELETE).collect(Collectors.toSet()));
    @Getter
    private final int value;
    @Getter
    private final Set<AccountPermission> permissions;

    AccountType(int value, Set<AccountPermission> permissions) {
        this.value = value;
        this.permissions = permissions;
    }

}
