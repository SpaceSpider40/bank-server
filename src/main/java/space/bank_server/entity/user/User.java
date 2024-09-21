package space.bank_server.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.Account;

import java.util.Collection;

@Getter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "user")
    private Collection<ContactInfo> contactInfo;

    @OneToMany(mappedBy = "owner")
    private Collection<Account> account;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
