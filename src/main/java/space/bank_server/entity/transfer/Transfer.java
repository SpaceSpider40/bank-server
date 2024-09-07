package space.bank_server.entity.transfer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.Currency;
import space.bank_server.entity.account.PrivateAccount;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transfer {
    @Id
    @GeneratedValue
    private long id;

    @Enumerated
    private Currency currency;

    private String Title;

    @ManyToOne(optional = false)
    private PrivateAccount SenderPrivateAccount;

    @ManyToOne(optional = false)
    private PrivateAccount ReceiverPrivateAccount;


}