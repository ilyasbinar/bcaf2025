package id.co.bcaf.pinjol_keren.controller;

import id.co.bcaf.pinjol_keren.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final CustomerService customerService;

    @Operation(summary = "Get all applications", description = "Get all application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer berhasil ditambahkan"),
            @ApiResponse(responseCode = "500", description = "Terjadi kesalahan saat mendapatkan application")
    })
    public ResponseEntity<Map<String, Object>> create() {

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Pendaftaran pelanggan berhasil");
        response.put("customerUser", null);

        return ResponseEntity.ok(response);
    }
}
