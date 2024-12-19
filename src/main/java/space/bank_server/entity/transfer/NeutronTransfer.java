package space.bank_server.entity.transfer;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.account.Currency;

@Entity
@Getter
@Setter
@Builder
public class NeutronTransfer {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Instant orderDate;
    private Instant sentDate;
    private Instant receivedDate;

    private Currency currency;

    private long amount;

    @ManyToOne
    private Account sender;

    @ManyToOne
    private Account receiver;
}
