package id.co.bcaf.pinjol_keren.dto.account;

import id.co.bcaf.pinjol_keren.model.account.Role;
import java.util.UUID;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;
    private String username;
    private Role role; // No password for security reasons
    private Boolean isActive;
}
