package com.entropy.backend.configurations.securities.jwts;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class create account principal use by JWT
 *
 * @author bac-ta
 * @see AccountPrincipal
 * @since 2021-05-31
 */
@Data
@NoArgsConstructor
public class AccountPrincipal implements UserDetails, OAuth2User {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String name; //For oauth2
    private Map<String, Object> attributes;//For oath2
    private Collection<? extends GrantedAuthority> authorities;

    public static AccountPrincipal create(String username, String email, String phone, String roleName, Set<String> permissionNames) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(roleName));
        permissionNames.forEach(name -> authorities.add(new SimpleGrantedAuthority(name)));

        AccountPrincipal principal = new AccountPrincipal();
        principal.setEmail(email);
        principal.setUsername(username);
        principal.setPhone(phone);
        principal.setAuthorities(authorities);

        return principal;
    }

    public static AccountPrincipal create(com.entropy.backend.models.entities.OAuth2User oAuth2UserEntity, Map<String, Object> attributes) {
//        List<GrantedAuthority> authorities = Collections.
//                singletonList(new SimpleGrantedAuthority(UserRole.CLIENT.name()));
//
//        AccountPrincipal principal = new AccountPrincipal();
//        principal.setAuthorities(authorities);
//        principal.setEmail(oAuth2UserEntity.getEmail());
//        principal.setName(oAuth2UserEntity.getName());
//        principal.setAttributes(attributes);

//        return principal;
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
