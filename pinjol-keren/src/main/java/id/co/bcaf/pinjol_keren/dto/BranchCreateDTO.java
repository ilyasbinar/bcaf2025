package id.co.bcaf.pinjol_keren.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchCreateDTO {
    @Schema(description = "Nama cabang", example = "Cabang Jakarta")
    @NotBlank(message = "Nama branch tidak boleh kosong")
    @Size(min = 3, max = 50, message = "Nama branch harus antara 3-50 karakter")
    private String name;

    @Schema(description = "Nomor telepon cabang", example = "08123456789")
    @NotBlank(message = "Nomor telepon tidak boleh kosong")
    @Size(min = 10, max = 15, message = "Nomor telepon harus antara 10-15 digit")
    private String phone;

    @Schema(description = "Alamat lengkap cabang", example = "Jl. Sudirman No.1, Jakarta")
    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    @Schema(description = "Provinsi cabang", example = "DKI Jakarta")
    @NotBlank(message = "Provinsi tidak boleh kosong")
    private String province;
}
