package space.bank_server.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.bank_server.entity.account.AccountType;
import space.bank_server.entity.account.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountCreationDTO {
    AccountType accountType;
    Currency currency;
    Long userId;
}