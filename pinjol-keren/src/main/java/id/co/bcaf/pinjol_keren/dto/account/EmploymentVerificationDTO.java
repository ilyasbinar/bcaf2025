package id.co.bcaf.pinjol_keren.dto.account;

import lombok.Data;

import java.util.UUID;

@Data
public class EmploymentVerificationDTO {
    private UUID customerId;
    private String employmentStatus; // Employed, Self-Employed, Unemployed
    private String companyName;
    private String companyAddress;
    private String jobTitle;
    private Long monthlyIncome;
    private String emergencyContactName;
    private String emergencyContactPhone;
}
