package hellotractor.com.service;

import hellotractor.com.model.Seller;
import hellotractor.com.repository.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    @Autowired
    private ISellerRepository sellerRepository;

    public String addSeller(Seller seller) {
        Optional<Seller> checkSeller = sellerRepository.findByEmail(seller.getEmail());
        if (checkSeller.isPresent()) {
            return "Seller already exists";
        }
        else {
            sellerRepository.save(seller);
            return "User added";
        }
    }
}
