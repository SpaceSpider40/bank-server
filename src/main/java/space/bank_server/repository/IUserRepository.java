package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.bank_server.entity.user.User;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

}
