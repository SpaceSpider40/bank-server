package space.bank_server.services.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import space.bank_server.repository.IPrivateAccountRepository;

@Service
@AllArgsConstructor
public class PrivateAccountService {

    private IPrivateAccountRepository repository;


}
