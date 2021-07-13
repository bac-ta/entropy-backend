package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.User;
import com.entropy.backend.repositories.customs.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bac-ta
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
    @Query("FROM User u JOIN FETCH u.role r JOIN FETCH r.permissions WHERE (u.email=:emailOrUsername OR u.username=:emailOrUsername) AND u.status=:status")
    Optional<User> loadUserAndAuthorities(String emailOrUsername, byte status);

    @Query("FROM User u JOIN FETCH u.role r JOIN FETCH r.permissions WHERE u.username=:emailOrUsername AND u.status=:status")
    Optional<User> loadUserAndAuthoritiesByUsername(String emailOrUsername, byte status);
}
