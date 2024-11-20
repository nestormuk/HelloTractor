package hellotractor.com.controller;

import hellotractor.com.model.Product;
import hellotractor.com.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    private  ProductService productServices;

    @PostMapping(value = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        String saveProduct = productService.addProduct(product);

        if (saveProduct.equalsIgnoreCase("Product added")) {
            return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(saveProduct, HttpStatus.CONFLICT);


    }
    @GetMapping(value = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProducts(Model model) {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

    }

//    @GetMapping("/home")
//    public String getAllProducts(Model model) {
//        List<Product> products = productService.getAllProducts(); // Fetch the list of products
//        model.addAttribute("products", products); // Add products to the model
//        return "html/index"; // Refers to products.html in the templates folder
//    }



}
