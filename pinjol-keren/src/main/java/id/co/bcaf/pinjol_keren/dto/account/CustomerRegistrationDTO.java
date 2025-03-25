package id.co.bcaf.pinjol_keren.dto.account;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegistrationDTO {

    @Schema(description = "Nama lengkap pelanggan", example = "John Doe")
    @NotBlank(message = "Nama wajib diisi")
    private String name;

    @Schema(description = "Email pelanggan yang digunakan sebagai username", example = "johndoe@example.com")
    @Email(message = "Format email tidak valid")
    @NotBlank(message = "Email wajib diisi")
    private String username; // Email sebagai username

    @Schema(description = "Password minimal 8 karakter", example = "password123")
    @NotBlank(message = "Password wajib diisi")
    @Size(min = 8, message = "Password minimal harus 8 karakter")
    private String password;

    @Schema(description = "Alamat lengkap pelanggan", example = "Jl. Merdeka No. 10, Jakarta")
    @NotBlank(message = "Alamat wajib diisi")
    private String address;

    @Schema(description = "Nomor telepon pelanggan yang valid", example = "+6281234567890")
    @NotBlank(message = "Nomor telepon wajib diisi")
    @Pattern(regexp = "^(\\+62|0)[0-9]{9,13}$", message = "Nomor telepon tidak valid")
    private String phone;
}

