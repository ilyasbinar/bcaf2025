package id.co.bcaf.pinjol_keren.services;

import id.co.bcaf.pinjol_keren.models.apps.Branch;
import id.co.bcaf.pinjol_keren.models.apps.Employee;
import id.co.bcaf.pinjol_keren.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    BranchService branchService;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeByBranchId(UUID branchId) {
        Branch branch = branchService.getById(branchId);
//        return getEmployeeByBranch(branch);
//        return branch.getEmployeeList();
        return employeeRepository.findAllByBranchId(branchId);
    }

    public  List<Employee> getEmployeeByBranch(Branch branch) {
        return employeeRepository.findAllByBranch(branch);
    }
}
