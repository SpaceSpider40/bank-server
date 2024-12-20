package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import space.bank_server.entity.transfer.NeutronTransfer;
import java.util.List;
import java.time.Instant;


public interface INeutronTransferRepository extends JpaRepository<NeutronTransfer, Long> {
    List<NeutronTransfer> findBySentDate(Instant sentDate);
}
