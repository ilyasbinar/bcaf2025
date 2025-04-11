package id.co.bcaf.pinjol_keren.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {
    @NotBlank(message = "Email wajib diisi")
//    @Email(message = "Email tidak valid")
    private String username;

    @NotBlank(message = "Password wajib diisi")
    private String password;
}
