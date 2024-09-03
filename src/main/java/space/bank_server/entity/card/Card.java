package space.bank_server.entity.card;

import jakarta.persistence.*;
import lombok.*;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.account.PrivateAccount;

import java.time.Instant;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
@Entity
public abstract class Card {

    @Id
    @GeneratedValue
    private long id;


    @Column(unique = true, nullable = false)
    private String cardNumber;


    @Column(nullable = false)
    private String securityCode;

    @Column(nullable = false)
    @Setter
    private Instant expiryDate;

    public abstract char getTypeChar();
}
