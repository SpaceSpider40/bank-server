package space.bank_server.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import space.bank_server.entity.account.Account;
import space.bank_server.repository.IAccountRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController("/account")
@AllArgsConstructor
public class AccountController {

    private IAccountRepository accountRepository;

    @GetMapping("/")
    public List<Account> getMethodName(@RequestParam String param) {
        return accountRepository.findAll();
    }

    
    
}
