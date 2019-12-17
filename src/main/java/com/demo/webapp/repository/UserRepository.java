package com.demo.webapp.repository;

import com.demo.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bac-ta
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailOrUserName(String email, String username);

    Optional<User> findById(Long id);
}
