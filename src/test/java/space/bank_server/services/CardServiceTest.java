package space.bank_server.services;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.bank_server.entity.account.PrivateAccount;
import space.bank_server.entity.card.debit.DebitCard;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardServiceTest {

    @Autowired
    CardService cardService;

    @Test
    void generateDebitCard() {

        DebitCard debitCard = cardService.generateDebitCard(PrivateAccount.builder().build());

        System.out.println(debitCard.getCardNumber());
        System.out.println(debitCard.getSecurityCode());
    }
}