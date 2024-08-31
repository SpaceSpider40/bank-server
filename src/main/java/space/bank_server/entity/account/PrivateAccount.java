package space.bank_server.entity.account;

import jakarta.persistence.*;
import lombok.*;
import space.bank_server.entity.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class PrivateAccount {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue
    private Long id;

    private float value;

    @Builder.Default
    private Currency currency = Currency.EUR;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    private User owner;

}
