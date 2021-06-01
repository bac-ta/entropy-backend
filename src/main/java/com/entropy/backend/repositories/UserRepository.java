package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.User;
import com.entropy.backend.models.enumerations.ApproveType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.enumerations.UserType;
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
    @Query("FROM User WHERE email=:emailOrUsername OR userName=:emailOrUsername AND approveType=:approveType AND statusType=:statusType AND userType=:userType")
    User findUser(String emailOrUsername, ApproveType approveType, StatusType statusType, UserType userType);

    Optional<User> findById(Long id);

    @Query("SELECT id FROM User WHERE statusType =:statusType AND approveType=:approveType")
    Optional<List<Long>> findUserRegistListWatting(String statusType, String approveType);
}
