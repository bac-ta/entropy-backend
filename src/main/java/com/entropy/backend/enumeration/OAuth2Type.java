package com.entropy.backend.enumeration;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum OAuth2Type {

    GOOGLE(0, "google"),
    FACEBOOK(1, "facebook"),
    GITHUB(2, "github");
    @Getter
    private int value;
    @Getter
    private String name;

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
