package id.co.bcaf.pinjol_keren;

import id.co.bcaf.pinjol_keren.controller.BranchController;
import id.co.bcaf.pinjol_keren.dto.LocationDTO;
import id.co.bcaf.pinjol_keren.model.apps.Branch;
import id.co.bcaf.pinjol_keren.security.jwt.AuthEntryPointJwt;
import id.co.bcaf.pinjol_keren.security.service.UserDetailsServiceImpl;
import id.co.bcaf.pinjol_keren.services.BranchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BranchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindNearestBranch() throws Exception {
        String requestJson = """
                {
                    "latitude": -6.2,
                    "longitude": 106.8
                }
                """;

        mockMvc.perform(post("/api/v1/branch/nearest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.latitude").exists())
                .andExpect(jsonPath("$.longitude").exists());
    }
}
