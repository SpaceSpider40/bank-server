package space.bank_server.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.web.bind.annotation.*;
import space.bank_server.entity.user.User;
import space.bank_server.exceptions.user.UserNotFountException;
import space.bank_server.repository.IUserRepository;
import space.bank_server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final IUserRepository userRepository;
    private final UserService service;

    @GetMapping("/")
    List<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/")
    User newUser(@RequestBody ObjectNode json){
        return service.addUser(
                json.get("firstName").asText(),
                json.get("lastName").asText(),
                json.get("userContact")
        );
    }

//    @PostMapping("/")
//    User newUser(){
//
//    }

    @GetMapping("/{id}")
    User one(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()-> new UserNotFountException(id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
