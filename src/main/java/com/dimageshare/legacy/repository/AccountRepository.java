package com.dimageshare.legacy.repository;

import com.dimageshare.legacy.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bac-ta
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsernameOrEmailAndPassword(String username, String email, String password);

    Account findByEmail(String email);

    Account findByPhoneNumber(String phoneNumber);

    Account findByUsername(String userName);

    Account save(Account adminAccount);
}
