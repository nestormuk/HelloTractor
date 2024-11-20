package hellotractor.com.controller;

import hellotractor.com.model.Product;
import hellotractor.com.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller

public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping(value = "/")
    public String getHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "html/index"; // This will render the `index.html` page
    }

    @GetMapping("/products/{id}")
    public String getProductDetails(@PathVariable("id") UUID id, Model model) {
        Optional<Product> optionalProduct = productService.getProductById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println("Found product: " + product.getProductTitle()); // Debugging line
            model.addAttribute("product", product);
            return "html/product-details";
        } else {
            System.out.println("Product not found for id: " + id); // Debugging line
            model.addAttribute("error", "Product not found");
            return "html/error";
        }
    }


}
