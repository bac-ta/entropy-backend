package com.entropy.backend.repository;

import com.entropy.backend.model.entity.OAuth2User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuth2UserRepository extends JpaRepository<OAuth2User, Long> {
    Optional<OAuth2User> findByEmail(String email);
}
