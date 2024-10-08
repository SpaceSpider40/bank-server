package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import space.bank_server.entity.transfer.NeutronTransfer;

public interface ITransferRepository extends JpaRepository<NeutronTransfer, Long> {

}
