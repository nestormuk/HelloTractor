package hellotractor.com.controller;

import hellotractor.com.model.Seller;
import hellotractor.com.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping(value = "saveSeller", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveSeller(@RequestBody Seller seller) {
        String saveBuyer = sellerService.addSeller(seller);

        if(saveBuyer.equalsIgnoreCase("Seller Exit")){
            return new ResponseEntity<>(saveBuyer, HttpStatus.CONFLICT);

        }
        return new ResponseEntity<>(saveBuyer, HttpStatus.CREATED);
    }
}
