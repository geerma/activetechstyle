package course.ensf607.assignment6.product;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.findProductsByCategory(category);
	}
    

   public Product getProductById(Long productId) {
       Optional<Product> productById = productRepository.findProductById(productId);
       if (productById.isEmpty()) {
           throw new IllegalStateException("Product doesn't exist!");
       }
       return productById.get();
   }
   

   @Transactional
	public void decreaseStockQuantity(Long id, Integer n) {
		Optional<Product> productOptional = productRepository.findProductById(id);
		if (productOptional.isEmpty()) {
			throw new IllegalStateException("Product doesn't exist!");
   		}
		Product product = productOptional.get();
		int currentQuantity = product.getStockQuantity();
		product.setStockQuantity(currentQuantity - n);
	}
	
    public void addNewProduct(Product product) {
        Optional<Product> productById = productRepository.findProductById(product.getId());
        if (productById.isPresent()) {
            throw new IllegalStateException("Product already exist!");
        }
        productRepository.save(product);
    }
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}