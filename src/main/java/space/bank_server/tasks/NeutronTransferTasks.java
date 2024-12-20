package space.bank_server.tasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.repository.INeutronTransferRepository;

@AllArgsConstructor
@Component
public class NeutronTransferTasks {

    private static final Logger log = LoggerFactory.getLogger(NeutronTransferTasks.class);

    private final INeutronTransferRepository neutronTransferRepository;

    @Scheduled(fixedRate = 5000)
    public void test(){
        List<NeutronTransfer> notSentTransfers = neutronTransferRepository.findBySentDate(null);

        //Subtract amount form senders account

        //Add amount to receivers account

        //Set sentDate to now
    }
}
