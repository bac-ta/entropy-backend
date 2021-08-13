package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findById(int id);

    Optional<Profile> findByOauth2UserId(int oauth2UserId);
}
