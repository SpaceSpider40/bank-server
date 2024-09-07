package space.bank_server.entity.account;

import jakarta.persistence.*;
import lombok.*;
import space.bank_server.entity.card.debit.DebitCard;
import space.bank_server.entity.transfer.Transfer;
import space.bank_server.entity.user.User;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class PrivateAccount extends Account {


    @Builder.Default
    private Currency currency = Currency.EUR;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    private User owner;

    @OneToMany(targetEntity = DebitCard.class, mappedBy = "privateAccount")
    private List<DebitCard> debitCards;
}
