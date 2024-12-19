package space.bank_server.dto.transfer;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NeutronCreationDTO {
    String title;

    Instant orderDate;

    Long amount;

    Long senderId;
    Long receiverId;
}
