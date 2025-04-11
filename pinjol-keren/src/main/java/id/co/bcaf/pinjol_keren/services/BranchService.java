package id.co.bcaf.pinjol_keren.services;

import id.co.bcaf.pinjol_keren.dto.BranchCreateDTO;
import id.co.bcaf.pinjol_keren.dto.LocationDTO;
import id.co.bcaf.pinjol_keren.model.apps.Branch;
import id.co.bcaf.pinjol_keren.repositories.BranchRepository;
import id.co.bcaf.pinjol_keren.utils.GeoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getBranches(){
        return branchRepository.findAll();
    }

    public Branch getNearestBranch(LocationDTO location) {
        List<Branch> branches = branchRepository.findAll();

        return branches.stream()
                .min(Comparator.comparingDouble(b ->
                        GeoUtils.haversine(
                                location.getLatitude(),
                                location.getLongitude(),
                                b.getLatitude(),
                                b.getLongitude()
                        )))
                .orElse(null);
    }

    public Branch getById(UUID branchId) throws Exception {
        System.out.println("Tetst");
        return branchRepository.findById(branchId).orElse(null);
    }

    public void createBranch(BranchCreateDTO branchCreateDTO) {

    }
}
