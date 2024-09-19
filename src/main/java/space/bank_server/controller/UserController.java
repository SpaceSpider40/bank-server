package space.bank_server.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.bank_server.entity.user.User;
import space.bank_server.exceptions.user.UserNotFountException;
import space.bank_server.repository.IUserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final IUserRepository userRepository;

    @GetMapping("/")
    List<User> all(){
        return userRepository.findAll();
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
