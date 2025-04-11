package id.co.bcaf.pinjol_keren.controller;

import id.co.bcaf.pinjol_keren.dto.CustomerUserDTO;
import id.co.bcaf.pinjol_keren.dto.account.CustomerRegistrationDTO;
import id.co.bcaf.pinjol_keren.model.account.Customer;
import id.co.bcaf.pinjol_keren.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "API untuk mengelola data customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/register")
    @Operation(summary = "Register a customer", description = "Customer mendaftar ke aplikasi")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Customer berhasil ditambahkan"),
            @ApiResponse(responseCode = "400", description = "Validasi gagal"),
            @ApiResponse(responseCode = "500", description = "Terjadi kesalahan saat menambahkan customer")
    })
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody CustomerRegistrationDTO customerRegistrationDTO) {
        Customer customer = customerService.registerCustomer(customerRegistrationDTO);
        CustomerUserDTO customerUserDTO = new CustomerUserDTO(customer.getUser(), customer); // Ambil data dari User & Customer

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Pendaftaran pelanggan berhasil");
        response.put("customerUser", customerUserDTO);

        return ResponseEntity.ok(response);
    }
}
