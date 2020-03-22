package com.entropy.backend.repository;

import com.entropy.backend.entity.User;
import com.entropy.backend.enumeration.ApproveType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.enumeration.UserType;
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
    @Query("FROM User WHERE email=:email OR userName=:username AND approveType=:approveType AND statusType=:statusType AND userType=:userType")
    User findUser(String email, String username, ApproveType approveType, StatusType statusType, UserType userType);

    Optional<User> findById(Long id);

    @Query("SELECT id FROM User WHERE statusType =:statusType AND approveType=:approveType")
    Optional<List<Long>> findUserRegistListWatting(String statusType, String approveType);
}
