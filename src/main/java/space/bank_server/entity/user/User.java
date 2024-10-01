package space.bank_server.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.Account;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NoArgsConstructor
@Table(name = "_user")
@Getter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    String firstName;
    String lastName;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<ContactInfo> contactInfos;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;    

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
