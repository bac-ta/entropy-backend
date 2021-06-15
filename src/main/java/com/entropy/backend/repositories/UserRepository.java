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
    @Query("FROM User WHERE email=:emailOrUsername OR username=:emailOrUsername AND status=:status AND type=:type")
    User findUser(String emailOrUsername, byte status, byte type);

    User findUserByUsername(String username);
}
