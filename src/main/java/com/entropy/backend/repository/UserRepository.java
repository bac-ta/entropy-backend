package com.entropy.backend.repository;

import com.entropy.backend.entity.User;
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
    User findByEmailOrUserName(String email, String username);

    Optional<User> findById(Long id);

    @Query("SELECT id FROM User WHERE statusType =:statusType AND approveType=:approveType")
    Optional<List<Long>> findUserRegistListWatting(String statusType, String approveType);
}
