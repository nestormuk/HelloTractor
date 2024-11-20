package hellotractor.com.service;

import hellotractor.com.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    String addProduct(Product product);
}
