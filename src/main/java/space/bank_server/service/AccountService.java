package space.bank_server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.account.AccountType;
import space.bank_server.entity.account.Currency;
import space.bank_server.entity.user.User;
import space.bank_server.exceptions.user.UserCreationException;
import space.bank_server.repository.IAccountRepository;
import space.bank_server.repository.IUserRepository;

@Service
@AllArgsConstructor
public class AccountService {

    private final UserService userService;

    private final IAccountRepository accountRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account createPrivateAccount(Currency currency, Long userId){

        User user = userService.getUser(userId);

        if (user == null) throw new UserCreationException("User not found");

        Account account = new Account(
            AccountType.PRIVATE,
            currency,
            user
        );

        accountRepository.save(account);
        accountRepository.flush();

        return account;
    }
}
