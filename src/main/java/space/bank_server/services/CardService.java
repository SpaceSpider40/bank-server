package space.bank_server.services;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import space.bank_server.entity.account.PrivateAccount;
import space.bank_server.entity.card.Card;
import space.bank_server.entity.card.debit.DebitCard;
import space.bank_server.repository.IDebitCardRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.regex.Pattern;


@Service
@AllArgsConstructor
public class CardService {

    private IDebitCardRepository debitCardRepository;

    //Time of how long card is valid provided in years
    //TODO: make it configurable
    public static short CARD_VALID_TIME = 4;

    public DebitCard generateDebitCard(PrivateAccount owner){
        DebitCard card = new DebitCard();
        card.setCardNumber(getCardNumber(card));
        card.setSecurityCode(getSecurityCode());

        return card;
    }

    private String getSecurityCode(){
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }

    private String getCardNumber(Card card) {
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        for (int i = 1; i < 16; i++) {
            sb.append(rand.nextInt(10));

            if (i % 4 == 0){
                sb.append(" ");
            }
        }

        sb.append(card.getTypeChar());

        //if validation fails try to generate card again
        if (!validateCardNumber(sb.toString())){
            return getCardNumber(card);
        }

        return sb.toString();
    }

    private boolean validateCardNumber(String cardNumber){
        //TODO: change repository depending on last number
        return !debitCardRepository.existsByCardNumber(cardNumber);
    }

    private boolean validateSecurityCode(String securityCode){

        Pattern pattern = Pattern.compile("^[0-9]{3}$");

        return pattern.matcher(securityCode).find();
    }

    /**
     * Calculates the date of expiry from now
     *
     * @return expiry date
     */
    private static Instant getExpiryDate() {
        return Instant.now().plus(CARD_VALID_TIME, ChronoUnit.YEARS);
    }

    /**
     * Calculates the date of expiry from passed date
     *
     * @param from the date from which, expiry date will be calculated
     * @return expiry date
     */
    private static Instant getExpiryDate(@NotNull Instant from) {
        return from.plus(CARD_VALID_TIME, ChronoUnit.YEARS);
    }
}
