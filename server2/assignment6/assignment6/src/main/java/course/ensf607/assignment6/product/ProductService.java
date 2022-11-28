package course.ensf607.assignment6.product;

import java.math.BigDecimal;
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
   
   
	public Product getProductByName(String name) {
		Optional<Product> productByName = productRepository.findProductByName(name);
		if (productByName.isEmpty()) {
			throw new IllegalStateException("Product doesn't exist!");
		}
		return productByName.get();
	}
	
   
   public List<Product> getAllProducts() {
		return productRepository.findAll();
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
		Optional<Product> billingById = productRepository.findProductById(product.getId());
		if (billingById.isPresent()) {
			throw new IllegalStateException("Billing already exist!");
		}
		productRepository.save(product);
	}


	public void updateProduct(Long id, String name, String category, Double rating, BigDecimal price, String image,
			Integer stockQuantity, String stockLocation, String description) {

		Optional<Product> productOptional = productRepository.findProductById(id);
    	if (productOptional.isEmpty()) {
    		throw new IllegalStateException("Product does not exist!");
    	}
    	
    	Product product = productOptional.get();
    		
		if (name != product.getName()) {
			Optional<Product> productO = productRepository.findProductByName(name);
			if (productO.isPresent()) {
				throw new IllegalStateException("Card number is already taken!");
			}
			product.setName(name);
		}
		
		product.setCategory(category);
		product.setRating(rating);
		product.setPrice(price);
		product.setImage(image);
		product.setStockQuantity(stockQuantity);
		product.setStockLocation(stockLocation);
		product.setDescription(description);
		
	}


	
	
	
   

}