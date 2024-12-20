package space.bank_server.entity.transfer;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.account.Currency;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnoreProperties({"user", "outboundTransfers", "inboundTransfers"})
    @ManyToOne(targetEntity = Account.class)
    private Account sender;

    @JsonIgnoreProperties({"user", "outboundTransfers", "inboundTransfers"})
    @ManyToOne(targetEntity = Account.class)
    private Account receiver;
}
