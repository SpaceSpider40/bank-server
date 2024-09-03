package space.bank_server.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import space.bank_server.entity.account.PrivateAccount;
import space.bank_server.entity.card.Card;
import space.bank_server.entity.card.debit.DebitCard;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;


@Service
public class CardService {

    //Time of how long card is valid provided in years
    public static short CARD_VALID_TIME = 4;

    public DebitCard generateDebitCard(PrivateAccount owner){
        DebitCard card = new DebitCard();
        card.setCardNumber(getCardNumber(card));

        return card;
    }

    private static String getCardNumber(Card card) {
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            sb.append(rand.nextInt(10)-1);

            if (i % 4 == 0){
                sb.append(" ");
            }
        }

        sb.append(card.getTypeChar());

        return sb.toString();
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
