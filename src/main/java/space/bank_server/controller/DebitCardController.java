package space.bank_server.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.bank_server.entity.account.PrivateAccount;
import space.bank_server.entity.card.debit.DebitCard;
import space.bank_server.repository.IDebitCardRepository;
import space.bank_server.services.CardService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/card/debit")
@AllArgsConstructor
public class DebitCardController {

    static int cardLife = 4;

    private IDebitCardRepository debitCardRepository;
    private CardService cardService;

    //TODO: Change request body to only require user as card will be generated here
    @PostMapping("/add")
    private ResponseEntity<DebitCard> createDebitCard(@RequestBody DebitCard debitCard) {
        //TODO: validate

        debitCard.setExpiryDate(Instant.now().plus(4, ChronoUnit.YEARS));

        debitCardRepository.save(debitCard);
        debitCardRepository.flush();

        return ResponseEntity.status(HttpStatus.CREATED).body(debitCard);
    }

    @PostMapping("/genereate")
    private ResponseEntity<DebitCard> generateDebitCard(@RequestBody PrivateAccount privateAccount) {

        DebitCard debitCard = cardService.generateDebitCard(privateAccount);

        debitCardRepository.save(debitCard);
        debitCardRepository.flush();

        return ResponseEntity.status(HttpStatus.CREATED).body(debitCard);
    }

    private Instant generateCardExpiryDate() {
        return Instant.now().plus(cardLife, ChronoUnit.YEARS);
    }

    private Instant generateCardExpiryDate(Instant from) {
        return from.plus(cardLife, ChronoUnit.YEARS);
    }
}
