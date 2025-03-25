package id.co.bcaf.pinjol_keren.security.jwt;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private List<String> features;
    private String role;

    public JwtResponse(String token, String username, String role, List<String> features) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.features = features;
    }
}