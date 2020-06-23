package com.entropy.backend.service;

import com.entropy.backend.constant.ExceptionMessage;
import com.entropy.backend.enumeration.OAuth2Type;
import com.entropy.backend.model.entity.Profile;
import com.entropy.backend.repository.OAuth2UserRepository;
import com.entropy.backend.repository.ProfileRepository;
import com.entropy.backend.security.jwt.AccountPrincipal;
import com.entropy.backend.security.pattern.factory.OAuth2UserInfoFactory;
import com.entropy.backend.security.pattern.template.OAuth2UserInfoTemplate;
import com.entropy.backend.util.OAuth2AuthenticationProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OAuth2UserCustomService extends DefaultOAuth2UserService {
    private final OAuth2UserRepository oAuth2UserRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public OAuth2UserCustomService(OAuth2UserRepository oAuth2UserRepository, ProfileRepository profileRepository) {
        this.oAuth2UserRepository = oAuth2UserRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();

        OAuth2UserInfoTemplate template = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, oAuth2User.getAttributes());

        String email = template.getEmail();
        if (StringUtils.isEmpty(email))
            throw new OAuth2AuthenticationProcessingException(ExceptionMessage.EMAIL_NOT_FOUND_FROM_PROVIDER);

        com.entropy.backend.model.entity.OAuth2User oAuth2UserEntity;
        Optional<com.entropy.backend.model.entity.OAuth2User> optionalOAuth2User = oAuth2UserRepository.findByEmail(email);

        if (optionalOAuth2User.isPresent()) {
            oAuth2UserEntity = optionalOAuth2User.get();
            if (!OAuth2Type.valueOf(registrationId).equals(oAuth2UserEntity.getOAuth2Type()))
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        oAuth2UserEntity.getOAuth2Type() + " account. Please use your " + oAuth2UserEntity.getOAuth2Type() +
                        " account to login.");
            oAuth2UserEntity = updateExisting(oAuth2UserEntity, template);
        } else {
            oAuth2UserEntity = registerUser(oAuth2UserRequest, template);
        }
        return AccountPrincipal.create(oAuth2UserEntity, oAuth2User.getAttributes());
    }

    private com.entropy.backend.model.entity.OAuth2User registerUser(OAuth2UserRequest request, OAuth2UserInfoTemplate template) {
        com.entropy.backend.model.entity.OAuth2User oAuth2UserEntity = new com.entropy.backend.model.entity.OAuth2User();
        oAuth2UserEntity.setName(template.getName());
        oAuth2UserEntity.setEmail(template.getEmail());
        oAuth2UserEntity.setOAuth2Type(OAuth2Type.valueOf(request.getClientRegistration().getRegistrationId()));
        com.entropy.backend.model.entity.OAuth2User oAuth2UserEntitySaved = oAuth2UserRepository.save(oAuth2UserEntity);
        Profile profile = new Profile();
        profile.setOauth2Avatar(template.getImageUrl());
        profile.setOauth2UserId(oAuth2UserEntitySaved.getId());
        profileRepository.save(profile);

        return oAuth2UserEntitySaved;
    }

    private com.entropy.backend.model.entity.OAuth2User updateExisting(com.entropy.backend.model.entity.OAuth2User oAuth2UserEntity, OAuth2UserInfoTemplate template) {
        oAuth2UserEntity.setName(template.getName());
        if (!StringUtils.isBlank(template.getImageUrl())) {
            Optional<Profile> profileOptional = profileRepository.findByOauth2UserId(oAuth2UserEntity.getId());
            if (profileOptional.isPresent()) {
                Profile profile = profileOptional.get();
                profile.setOauth2Avatar(template.getImageUrl());
                profileRepository.save(profile);
            }
        }

        return oAuth2UserRepository.save(oAuth2UserEntity);
    }
}
