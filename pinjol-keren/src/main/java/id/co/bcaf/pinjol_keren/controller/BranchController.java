package id.co.bcaf.pinjol_keren.controller;

import id.co.bcaf.pinjol_keren.dto.BranchCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/branch")
@Tag(name = "Branch", description = "API untuk mengelola cabang")
public class BranchController {

    @PostMapping("/form")
    @Operation(summary = "Create a new branch", description = "Menambahkan cabang baru")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Branch berhasil ditambahkan"),
            @ApiResponse(responseCode = "400", description = "Validasi gagal"),
            @ApiResponse(responseCode = "500", description = "Terjadi kesalahan saat menambahkan branch")
    })
    public ResponseEntity<Map<String, Object>> createBranch(@Valid @RequestBody BranchCreateDTO branchCreateDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Simulate branch creation (Replace with actual service call)
            response.put("status", "success");
            response.put("message", "Branch berhasil ditambahkan");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Terjadi kesalahan saat menambahkan branch.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}