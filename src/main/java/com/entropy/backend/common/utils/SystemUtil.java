package com.entropy.backend.common.utils;

import org.springframework.util.SerializationUtils;

import javax.servlet.http.Cookie;
import java.util.Base64;
import java.util.UUID;

public class SystemUtil {
    public static String serialize(Object object) {
        return Base64.getUrlEncoder().encodeToString(SerializationUtils.serialize(object));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(SerializationUtils.deserialize(
                Base64.getUrlDecoder().decode(cookie.getValue())));
    }

    public static String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }
}
