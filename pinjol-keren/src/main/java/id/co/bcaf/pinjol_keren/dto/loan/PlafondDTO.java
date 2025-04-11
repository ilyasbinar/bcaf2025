package id.co.bcaf.pinjol_keren.dto.loan;

import lombok.Data;

import java.util.UUID;

@Data
public class PlafondDTO {
    private UUID customerId;
    private Long creditLimit;
    private String plafondStatus; // APPROVED, REJECTED, PENDING
    private String reason; // If rejected
}
