package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author bac-ta
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User WHERE email=:emailOrUsername OR username=:emailOrUsername AND approval=:approval AND status=:status AND type=:type")
    User findUser(String emailOrUsername, byte approval, byte status, byte type);

    @Query("FROM User WHERE username = :username OR email = :email OR phone = :phone")
    Optional<User> findUserExistBy(String username, String email, String phone);

    @Query("SELECT username FROM User WHERE status =:status AND approval=:approval")
    Optional<List<String>> findUserRegistListWatting(byte status, byte approval);
}
