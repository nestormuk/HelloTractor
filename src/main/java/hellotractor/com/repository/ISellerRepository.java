package hellotractor.com.repository;

import hellotractor.com.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, UUID> {

    Optional<Seller> findByEmail(String email);
}
