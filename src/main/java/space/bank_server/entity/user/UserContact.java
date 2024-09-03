package space.bank_server.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table
@Entity
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String information;

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Setter
    @Getter
    @ManyToOne(optional = false)
    private User user;

}
