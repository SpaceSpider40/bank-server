package space.bank_server.entity.account;

import jakarta.persistence.*;
import lombok.Getter;
import space.bank_server.entity.user.User;

@Entity
@Getter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private AccountType type;

    private long amount;

    @Enumerated
    private Currency currency;

    @ManyToOne(targetEntity = User.class)
    private User owner;
}
