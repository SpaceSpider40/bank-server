package space.bank_server.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import space.bank_server.entity.user.User;
import space.bank_server.repository.IUserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private IUserRepository userRepository;

    @PostMapping("/add")
    private ResponseEntity<Object> addUser(@RequestBody User user) {

        if (userRepository.existsById(user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Duplicated user id");
        }

        if (userRepository.findByIdentifier(user.getIdentifier()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Duplicated user identifier"
            );
        }

        String validationErrors = validateUser(user);

        if (validationErrors != null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    validationErrors
            );
        }

        userRepository.save(user);
        userRepository.flush();

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/deactivate")
    private ResponseEntity<Object> deactivateUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User not found"
            );
        }

        optionalUser.get().setActive(false);

        userRepository.save(optionalUser.get());
        userRepository.flush();

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    /**
     * Validates user object
     * @param user user to validate
     * @return String with error message, null if no errors found
     */
    private static String validateUser(User user) {

        StringBuilder sb = new StringBuilder();

        if (user.getFirstName().isEmpty()){
            sb.append("First name is required\n");
        }

        if (user.getLastName().isEmpty()){
            sb.append("Last name is required\n");
        }

        if (user.getIdentifier().isEmpty()){
            sb.append("Identifier is required\n");
        }

        if (user.getPassword().isEmpty()){
            sb.append("Password is required\n");
        }

//        if (user.getUserContacts().length < 1){
//            sb.append("At least one contact is required\n");
//        }

        if (!sb.isEmpty()){
            return sb.toString();
        }

        return null;
    }
}
