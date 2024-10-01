package space.bank_server.entity.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import space.bank_server.entity.user.User;

@Entity
@Getter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private final  AccountType type;

    private long amount;

    @Enumerated
    private final  Currency currency;

    @ManyToOne
    private final User user;

    public Account(AccountType type, Currency currency, User user){
        this.type = type;
        this.currency = currency;
        this.amount = 0;
        this.user = user;
    }

    public void addAmount(long amount){
        this.amount += amount;
    }

    public void subtractAmount(long amount){
        this.amount -= amount;
    }
}
