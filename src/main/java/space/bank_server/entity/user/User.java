package space.bank_server.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    String firstName;
    String lastName;

}
