package space.bank_server.entity.card.debit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class DebitCard {

    @Id
    @GeneratedValue
    private long id;

    private String cardNumber;

    private String securityCode;

    private Instant expiryDate;


}
