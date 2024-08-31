package space.bank_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.bank_server.entity.account.PrivateAccount;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/account/private")
public class PrivateAccountController {

    @PostMapping("/open")
    private ResponseEntity<PrivateAccount> openPrivateAccount(@RequestBody PrivateAccount account) {

        //TODO: validate inputted account

        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/close")
    private ResponseEntity<PrivateAccount> closePrivateAccount(@RequestBody PrivateAccount account) {

        //TODO: remove account from system

        return ResponseEntity.status(HttpStatus.OK).body(account);
    }



}