package space.bank_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.service.TransferService;


@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;
    
    @GetMapping("/neutron")
    List<NeutronTransfer> allNeutrons()
    {
        return transferService.getNeutronTransfers();
    }

    @PostMapping("/neutron")
    NeutronTransfer createNeutorn(){
        return transferService.creatNeutronTransfer();
    }
}
