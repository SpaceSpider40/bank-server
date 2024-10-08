package space.bank_server.dto.transfer;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.Account;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NeutronCreationDTO {
    String title;

    Instant orderDate;

    Long amount;

    Account sender;
    Account receiver;
}
