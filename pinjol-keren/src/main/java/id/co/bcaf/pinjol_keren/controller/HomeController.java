package id.co.bcaf.pinjol_keren.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/home")
@Tag(name = "Home", description = "Home test endpoint")
public class HomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/encode")
    @Operation(summary = "Encode a fixed password")
    public String encodePassword() {
        return passwordEncoder.encode("123456");
    }
}
