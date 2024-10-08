package space.bank_server.entity.account;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import space.bank_server.entity.transfer.NeutronTransfer;
import space.bank_server.entity.user.User;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;

    @Enumerated
    private  AccountType type;

    private long amount;

    @Enumerated
    private Currency currency;

    @ManyToOne
    private User user;

    @JsonIgnoreProperties("sender")
    @OneToMany(mappedBy = "sender")
    private List<NeutronTransfer> outboundTransfers;

    @JsonIgnoreProperties("receiver")
    @OneToMany(mappedBy = "receiver")
    private List<NeutronTransfer> inboundTransfers;

    public Account(AccountType type, Currency currency, User user){
        this.accountNumber = GenerateAccountNumber(type);

        this.type = type;
        this.currency = currency;
        this.amount = 0;
        this.user = user;
    }

    public void addAmount(long amount){
        this.amount += amount;
    }

    public void subtractAmount(long amount){
        this.amount -= amount;
    }

    private String GenerateRandomCode(byte length){
        Random r = new Random();


        StringBuilder sb = new StringBuilder();
        for(byte i = 0; i < length; i++){
            sb.append(r.nextInt(10));
        }

        return sb.toString();
    }

    private String GenerateBranchCode(AccountType accountType){
        switch (accountType) {
            case PRIVATE -> {
                return GenerateRandomCode((byte)5) + 0;
            }
            case COMPANY -> {
                return GenerateRandomCode((byte)5) + 1;
            }
            default -> throw new AssertionError();
        }
    }

    private String GenerateAccountNumber(AccountType accountType){
        return "PL" + //country code
                "00" + //check digit
                "0001" + // bank code
                GenerateBranchCode(accountType) +
                GenerateRandomCode((byte) 8);
    }
}
