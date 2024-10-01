package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import space.bank_server.entity.account.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
