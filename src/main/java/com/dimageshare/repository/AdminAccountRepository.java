package com.dimageshare.repository;

import com.dimageshare.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * @author bac-ta
 */
@Repository
public interface AdminAccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsernameOrEmailAndPassword(String username, String email, String password);

    Account findByEmail(String email);

    Account findByPhoneNumber(String phoneNumber);

    Account findByUsername(String userName);

    Account save(Account adminAccount);
}
