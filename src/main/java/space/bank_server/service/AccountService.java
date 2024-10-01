package space.bank_server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import space.bank_server.entity.account.Account;
import space.bank_server.repository.IAccountRepository;

@Service
@AllArgsConstructor
public class AccountService {

    private final IAccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account createAccount(){
        Account account = new Account();
        

        return account;
    }
}
