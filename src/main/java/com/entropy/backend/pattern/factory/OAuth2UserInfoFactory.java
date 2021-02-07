package com.entropy.backend.pattern.factory;

import com.entropy.backend.enumeration.OAuth2Type;
import com.entropy.backend.security.oauth2.FacebookOAuth2UserInfo;
import com.entropy.backend.security.oauth2.GithubOAuth2UserInfo;
import com.entropy.backend.pattern.template.OAuth2UserInfoTemplate;
import com.entropy.backend.util.OAuth2AuthenticationProcessingException;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfoTemplate getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(OAuth2Type.FACEBOOK.name()))
            return new FacebookOAuth2UserInfo(attributes);
        else if (registrationId.equalsIgnoreCase(OAuth2Type.GITHUB.name()))
            return new GithubOAuth2UserInfo(attributes);
        else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
