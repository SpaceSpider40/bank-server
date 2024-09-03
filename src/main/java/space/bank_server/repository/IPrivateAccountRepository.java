package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import space.bank_server.entity.account.PrivateAccount;

import java.util.Optional;

public interface IPrivateAccountRepository extends JpaRepository<PrivateAccount, Long> {
    @NonNull
    Optional<PrivateAccount> findById(@NonNull Long id);

}
