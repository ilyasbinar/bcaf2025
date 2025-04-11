package id.co.bcaf.pinjol_keren.model.loan;

import id.co.bcaf.pinjol_keren.model.account.Customer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loan_applications")
@Data
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Long requestedAmount;
    private Integer tenureMonths;
    private String disbursementMethod; // Bank Transfer, E-Wallet
    
    @Enumerated(EnumType.STRING)
    private LoanStatus status; // PENDING, APPROVED, REJECTED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
