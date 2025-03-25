package id.co.bcaf.pinjol_keren.repositories;

import id.co.bcaf.pinjol_keren.model.apps.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
    List<Branch> findAllByDeleted(boolean deleted);
    List<Branch> findAllByProvince(String province);
}
