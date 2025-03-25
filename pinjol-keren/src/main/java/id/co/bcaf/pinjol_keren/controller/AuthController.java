package id.co.bcaf.pinjol_keren.controller;

import id.co.bcaf.pinjol_keren.dto.LoginRequestDto;
import id.co.bcaf.pinjol_keren.model.account.Role;
import id.co.bcaf.pinjol_keren.model.account.User;
import id.co.bcaf.pinjol_keren.security.jwt.JwtResponse;
import id.co.bcaf.pinjol_keren.security.jwt.JwtUtils;
import id.co.bcaf.pinjol_keren.security.service.UserDetailsImpl;
import id.co.bcaf.pinjol_keren.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getUser().getRole().getCode();
        List<String> features = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        JwtResponse jwtResponse = new JwtResponse(jwt, userDetails.getUsername(), role, features);

        Map<String, Object> data = new HashMap<>();
        data.put("jwt", jwtResponse);
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}