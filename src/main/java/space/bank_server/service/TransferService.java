package space.bank_server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.repository.ITransferRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {

    private final ITransferRepository transferRepository;

    public List<NeutronTransfer> getNeutronTransfers(){
        return transferRepository.findAll();
    }

    public NeutronTransfer creatNeutronTransfer(){
        
    }
}
