package space.bank_server.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ContactInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private ContactInfoType type;

    private String value;

    @JsonIgnoreProperties("user")
    @ManyToOne
    private User user;

    public ContactInfo(ContactInfoType type, String value, User user) {
        this.type = type;
        this.value = value;
        this.user = user;
    }
}
