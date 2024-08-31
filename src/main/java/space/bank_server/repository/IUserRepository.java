package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import space.bank_server.entity.user.User;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long>{
    @NonNull
    Optional<User> findById(@NonNull Long id);

    Optional<User> findByIdentifier(@NonNull String identifier);
}
