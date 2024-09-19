package space.bank_server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import space.bank_server.exceptions.user.UserNotFountException;

@RestControllerAdvice
public class UserNotFoundAdvice {

    @ExceptionHandler(UserNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFountException ex) {
        return ex.getMessage();
    }
}
