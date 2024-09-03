package space.bank_server.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.PrivateAccount;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="_user")
public class User {

    @Id
    @Column(unique = true, nullable=false)
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable=false)
    private String identifier;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;

    @OneToMany(targetEntity = UserContact.class, mappedBy = "user")
    private Collection<UserContact> contacts;
    
    @OneToMany(targetEntity = PrivateAccount.class, mappedBy = "owner")
    private Collection<PrivateAccount> privateAccounts;

    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
