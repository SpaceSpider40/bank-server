package space.bank_server.entity.card.debit;

import jakarta.persistence.*;
import lombok.*;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.account.PrivateAccount;
import space.bank_server.entity.card.Card;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table
@Data
public class DebitCard extends Card {



    @Setter
    @ManyToOne(optional = false)
    private PrivateAccount privateAccount;

    private boolean isActive;

    private boolean isBlocked;

    @Override
    public char getTypeChar() {
        return '0';
    }
}
