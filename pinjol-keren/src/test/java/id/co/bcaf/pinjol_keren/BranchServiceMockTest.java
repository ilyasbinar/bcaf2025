package id.co.bcaf.pinjol_keren;

import id.co.bcaf.pinjol_keren.dto.LocationDTO;
import id.co.bcaf.pinjol_keren.model.apps.Branch;
import id.co.bcaf.pinjol_keren.repositories.BranchRepository;
import id.co.bcaf.pinjol_keren.services.BranchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BranchServiceMockTest {

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private BranchService branchService;

    @Test
    public void testFindNearestBranch_returnsClosestBranch() {
        // Arrange
        Branch jakarta = new Branch();
        jakarta.setName("Branch Jakarta");
        jakarta.setLatitude(-6.2);
        jakarta.setLongitude(106.8);

        Branch bandung = new Branch();
        bandung.setName("Branch Bandung");
        bandung.setLatitude(-6.9);
        bandung.setLongitude(107.6);

        List<Branch> branches = List.of(jakarta, bandung);

        when(branchRepository.findAll()).thenReturn(branches);

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLatitude(-6.5);
        locationDTO.setLongitude(106.9);

        // Act
        Branch nearest = branchService.getNearestBranch(locationDTO); // lokasi dekat Jakarta

        // Assert
        assertNotNull(nearest);
        assertEquals("Branch Jakarta", nearest.getName());
    }
}
