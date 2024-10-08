package space.bank_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import space.bank_server.dto.account.AccountCreationDTO;
import space.bank_server.entity.account.Account;
import space.bank_server.service.AccountService;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/")
    List<Account> all() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/")
    Account add(@RequestBody AccountCreationDTO accountCreationDTO) {
        return accountService.createPrivateAccount(accountCreationDTO.getCurrency(), accountCreationDTO.getUserId());
    }
}
