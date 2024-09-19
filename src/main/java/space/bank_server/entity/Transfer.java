package space.bank_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import space.bank_server.entity.account.Account;

import java.time.Instant;

@Entity
@Getter
public class Transfer {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Instant order_date;
    private Instant received_date;

    private long amount;

    @ManyToOne(targetEntity = Account.class)
    private Account sender;

    @ManyToOne(targetEntity = Account.class)
    private Account receiver;
}
