package id.co.bcaf.pinjol_keren.services;

import id.co.bcaf.pinjol_keren.models.apps.Branch;
import id.co.bcaf.pinjol_keren.models.apps.Employee;
import id.co.bcaf.pinjol_keren.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getBranches(){
        branchRepository.findAll();

//        branchRepository.findAllByDeleted(false);
        return null;
    }

    public Branch getById(UUID branchId) {
        return branchRepository.findById(branchId).get();
    }
}
