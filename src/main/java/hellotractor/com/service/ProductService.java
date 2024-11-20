package hellotractor.com.service;

import hellotractor.com.model.Product;
import hellotractor.com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    public String addProduct(Product product) {
        Product product1 = productRepository.save(product);
        if (product1 != null) {
            return "Product added";
        }
        return "Product not added";
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }
}
