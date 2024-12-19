package space.bank_server.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import space.bank_server.dto.transfer.NeutronCreationDTO;
import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.service.TransferService;

@RestController
@RequestMapping("/api/v1/transfer")
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @GetMapping("/neutron")
    List<NeutronTransfer> allNeutrons() {
        return transferService.getNeutronTransfers();
    }

    @PostMapping("/neutron")
    ResponseEntity<?> createNeutron(@RequestBody NeutronCreationDTO neutronCreationDTO) {
        try {
            transferService.createNeutronTransfer(neutronCreationDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
