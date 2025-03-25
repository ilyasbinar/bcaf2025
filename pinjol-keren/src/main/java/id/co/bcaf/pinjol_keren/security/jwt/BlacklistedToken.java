package id.co.bcaf.pinjol_keren.security.jwt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blacklisted_tokens")
public class BlacklistedToken {
    @Id
    private String token;
    private LocalDateTime expiryDate;
}
