package id.co.bcaf.pinjol_keren.repositories;

import id.co.bcaf.pinjol_keren.models.apps.Branch;
import id.co.bcaf.pinjol_keren.models.apps.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findAllByBranch(Branch branch);

    @Query("select e FROM Employee e JOIN Branch b where b.id =: branchId")
    List<Employee> findAllByBranchId(UUID branchId);
}
