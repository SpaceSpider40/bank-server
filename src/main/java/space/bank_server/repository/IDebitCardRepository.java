package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.bank_server.entity.card.debit.DebitCard;

public interface IDebitCardRepository extends JpaRepository<DebitCard, Integer> {
    boolean existsByCardNumber(String cardNumber);
}
