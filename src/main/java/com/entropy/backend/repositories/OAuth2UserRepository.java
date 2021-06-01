package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.OAuth2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OAuth2UserRepository extends JpaRepository<OAuth2User, Long> {
    Optional<OAuth2User> findByEmail(String email);
}
