package hellotractor.com.controller;

import hellotractor.com.service.BuyerService;
import hellotractor.com.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping(value = "/saveBuyer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBuyer(@RequestBody Buyer buyer) {
        String saveBuyer = buyerService.addBuyer(buyer);

        if (saveBuyer.equalsIgnoreCase("Buyer already exists")) {
            return new ResponseEntity<>(saveBuyer, HttpStatus.CONFLICT);
        }
        else{
            return new ResponseEntity<>(saveBuyer, HttpStatus.CREATED);
        }

    }
}
