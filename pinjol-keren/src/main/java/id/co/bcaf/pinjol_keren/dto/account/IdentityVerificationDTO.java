package id.co.bcaf.pinjol_keren.dto.account;

import lombok.Data;

import java.util.UUID;

@Data
public class IdentityVerificationDTO {
    private UUID customerId;
    private String nik; // Extracted from KTP OCR
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String selfieImageUrl; // For facial verification
}
