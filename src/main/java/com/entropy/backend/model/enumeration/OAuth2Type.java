package com.entropy.backend.model.enumeration;

import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum OAuth2Type {
    FACEBOOK(0, "facebook"),
    GITHUB(1, "github");
    @Getter
    private final int value;
    @Getter
    private final String name;

    OAuth2Type(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static OAuth2Type findByValue(int value) {
        return Arrays.stream(OAuth2Type.values())
                .filter(oauth2Type -> oauth2Type.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.OAUTH2_TYPE_INVALID));
    }
}
