package id.co.bcaf.pinjol_keren.repositories;

import id.co.bcaf.pinjol_keren.models.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
