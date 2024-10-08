package space.bank_server.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import space.bank_server.dto.user.UserCreationDTO;
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
    User newUser(@RequestBody UserCreationDTO userCreationDTO){
        return service.addUser(
                userCreationDTO.getFirstName(),
                userCreationDTO.getLastName(),
                userCreationDTO.getUserContactInfo()
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
