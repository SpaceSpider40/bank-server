package space.bank_server.entity.account;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Account {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue
    private Long id;

    private float value;
}
