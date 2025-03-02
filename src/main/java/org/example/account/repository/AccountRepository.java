package org.example.account.repository;

import org.example.account.domain.Account;
import org.example.account.domain.AccountUser;
import org.example.account.type.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findFirstByOrderByIdDesc();

    Optional<Account> findByAccountNumber(String AccountNumber);

    Integer countByAccountUserAndAccountStatus(AccountUser accountUser, AccountStatus accountStatus);

    List<Account> findByAccountUser(AccountUser accountUser);
}
