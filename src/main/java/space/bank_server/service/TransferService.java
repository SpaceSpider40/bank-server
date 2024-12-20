package space.bank_server.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import space.bank_server.dto.transfer.NeutronCreationDTO;
import space.bank_server.entity.account.Account;
import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.repository.IAccountRepository;
import space.bank_server.repository.INeutronTransferRepository;

@Service
@AllArgsConstructor
public class TransferService {

    private final INeutronTransferRepository transferRepository;
    private final IAccountRepository accountRepository;

    public List<NeutronTransfer> getNeutronTransfers(){
        return transferRepository.findAll();
    }

    public boolean createNeutronTransfer(NeutronCreationDTO creationDTO) throws IllegalArgumentException
    {
        //Validate input
        if (creationDTO.getTitle() == null || creationDTO.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty or null");
        }

        if (creationDTO.getOrderDate() == null) {
            throw new IllegalArgumentException("Order date cannot be null");
        }

        if (creationDTO.getOrderDate().isAfter(Instant.now())) {
            throw new IllegalArgumentException("Order date cannot be in the future");
        }

        if (creationDTO.getAmount() == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        if (creationDTO.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (creationDTO.getSenderId() == null || creationDTO.getReceiverId() == null) {
            throw new IllegalArgumentException("Sender id and receiver id must be specified");
        }

        if (creationDTO.getSenderId().equals(creationDTO.getReceiverId())) {
            throw new IllegalArgumentException("Sender and receiver cannot be the same account");
        }

        Account sender = accountRepository.findById(creationDTO.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));

        Account receiver = accountRepository.findById(creationDTO.getReceiverId())
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        saveTransfer(NeutronTransfer.builder()
                .title(creationDTO.getTitle())
                .orderDate(creationDTO.getOrderDate())
                .amount(creationDTO.getAmount())
                .sender(sender)
                .receiver(receiver)
                .build());

        return true;
    }

    private void saveTransfer(NeutronTransfer transfer){
        transferRepository.save(transfer);
        transferRepository.flush();
    }
}
