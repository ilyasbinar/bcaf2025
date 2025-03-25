package id.co.bcaf.pinjol_keren.repositories;

import id.co.bcaf.pinjol_keren.model.account.RoleFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleFeatureRepository extends JpaRepository<RoleFeature, UUID> {
    boolean existsByRoleNameInAndFeatureName(List<String> roleNames, String featureName);
}
