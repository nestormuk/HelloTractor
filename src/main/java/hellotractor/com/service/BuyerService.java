package hellotractor.com.service;

import hellotractor.com.model.Buyer;
import hellotractor.com.repository.IBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private IBuyerRepository repository;

    public String addBuyer(Buyer buyer) {

        Optional<Buyer> checkBuyer =repository.findByEmail(
            buyer.getEmail()
        );
        if (checkBuyer.isPresent()) {
            return "Buyer already exists";
        }
        repository.save(buyer);
        return "Buyer registered successfully";
    }
}
