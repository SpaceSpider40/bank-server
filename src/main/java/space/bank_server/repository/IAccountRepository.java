package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import space.bank_server.entity.account.Account;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    
    @NonNull
    Optional<Account> findById(@NonNull Long id);
}
