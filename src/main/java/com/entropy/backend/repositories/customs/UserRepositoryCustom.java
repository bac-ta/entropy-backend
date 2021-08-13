package com.entropy.backend.repositories.customs;

import com.entropy.backend.models.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface custom repository handle logic for user
 *
 * @author bac-ta
 * @see UserRepositoryCustom
 * @since 2021-06-15
 */
@Repository
public interface UserRepositoryCustom {
    Optional<User> findUserExistBy(String username, String email, String phone);
}
