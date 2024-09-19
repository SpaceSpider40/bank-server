package space.bank_server.exceptions.user;

public class UserNotFountException extends RuntimeException {
    public UserNotFountException(Long id) {
        super("Could not find user with id " + id);
    }
}
