package com.entropy.backend.middleware.jwt;

import com.entropy.backend.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bac-ta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPrincipal implements UserDetails {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static AccountPrincipal create(User user) {
        String userType = user.getUserType().name();
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(userType));
        return new AccountPrincipal(user.getId(), user.getEmail(), user.getUserName(), user.getPassword(), authorities);
    }

    @Override
    public String getUsername() {
        return userName;
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
