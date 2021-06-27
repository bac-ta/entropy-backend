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
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    @Query("FROM User u JOIN FETCH u.role r JOIN FETCH r.permissions WHERE (u.email=:emailOrUsername OR u.username=:emailOrUsername) AND u.status=:status")
    User loadUserAndAuthorities(String emailOrUsername, byte status);

    @Query("FROM User u JOIN FETCH u.role r JOIN FETCH r.permissions WHERE u.Id=:id AND u.status=:status")
    User loadUserAndAuthorities(int id, byte status);

    @Query("FROM User WHERE username=:username AND status=:status")
    Optional<User> findUserByUsernameAndStatus(String username, byte status);

    @Query("FROM User WHERE username=:username")
    User findUserByUsername(String username);
}
