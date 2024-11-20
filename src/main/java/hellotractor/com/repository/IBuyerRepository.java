package hellotractor.com.repository;

import hellotractor.com.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IBuyerRepository extends JpaRepository<Buyer, UUID> {

    Optional<Buyer> findByEmail(String email);
}
