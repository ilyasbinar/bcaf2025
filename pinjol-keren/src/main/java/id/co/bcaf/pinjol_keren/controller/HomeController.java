package id.co.bcaf.pinjol_keren.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/home")
@Tag(name = "Branch", description = "API Beranda")
public class HomeController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return passwordEncoder.encode("123456");
    }
}