package lithan.abc.cars.repository;

import lithan.abc.cars.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lithan.abc.cars.entity.SendInquiries;

import java.util.List;

@Repository
public interface SendInquiriesRepository extends JpaRepository<SendInquiries, Integer> {
    List<SendInquiries> findByUser(UserAccount user);
}
