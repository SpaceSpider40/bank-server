package space.bank_server.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.bank_server.entity.user.ContactInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationDTO {
    private String firstName;
    private String lastName;

    private ContactInfo userContactInfo;
}
