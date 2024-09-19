package space.bank_server.entity.user;

import jakarta.persistence.*;

@Entity
public class ContactInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private ContactInfoType type;

    private String value;

    @ManyToOne(targetEntity = User.class)
    private User user;
}
