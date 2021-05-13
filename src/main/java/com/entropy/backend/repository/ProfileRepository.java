package com.entropy.backend.repository;

import com.entropy.backend.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findById(Long id);

    Optional<Profile> findByOauth2UserId(Long oauth2UserId);
}
