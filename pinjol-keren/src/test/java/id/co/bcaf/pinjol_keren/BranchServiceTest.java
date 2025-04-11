package id.co.bcaf.pinjol_keren;

import id.co.bcaf.pinjol_keren.dto.LocationDTO;
import id.co.bcaf.pinjol_keren.model.apps.Branch;
import id.co.bcaf.pinjol_keren.repositories.BranchRepository;
import id.co.bcaf.pinjol_keren.services.BranchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BranchServiceTest {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchService branchService;

//    @BeforeEach
//    void setUp() {
//        branchRepository.deleteAll();
//
//        Branch jakarta = new Branch();
//        jakarta.setName("Branch Jakarta");
//        jakarta.setLatitude(-6.2);
//        jakarta.setLongitude(106.8);
//        branchRepository.save(jakarta);
//
//        Branch bandung = new Branch();
//        bandung.setName("Branch Bandung");
//        bandung.setLatitude(-6.9);
//        bandung.setLongitude(107.6);
//        branchRepository.save(bandung);
//    }

    @Test
    void testGetNearestBranch_withRealData() {
        LocationDTO locationDTO = new LocationDTO();
        //Surabaya
//        locationDTO.setLatitude(-7.2);
//        locationDTO.setLongitude(112.7);

        //Bandung
        locationDTO.setLatitude(-6.9);
        locationDTO.setLongitude(107.6);

        Branch nearest = branchService.getNearestBranch(locationDTO);

        assertNotNull(nearest);
        assertEquals("Branch Bandung", nearest.getName());
    }
}
