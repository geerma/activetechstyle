package course.ensf607.assignment6.cart;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.ensf607.assignment6.product.Product;
import course.ensf607.assignment6.product.ProductService;

@Service
public class CartService {
	
	private final CartRepository cartRepository;
	private final ProductService productService;
	
	@Autowired
    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService =  productService;

    }
	

	public Cart getCartById(Long cartId) {
		Optional<Cart> cartById = cartRepository.findCartById(cartId);
        if (cartById.isEmpty()) {
            throw new IllegalStateException("Cart doesn't exist!");
        }
        return cartById.get();
	}
	
	

	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	public void addNewCart(Cart cart) {
		Optional<Cart> cartById = cartRepository.findCartById(cart.getId());
		if (cartById.isPresent()) {
			throw new IllegalStateException("Cart already exist!");
		}
		cartRepository.save(cart);
	}
	
	@Transactional
	public void updateCart(Long id, String status, BigDecimal totalPay, Date purchaseDate) {
		Optional<Cart> cartOptional = cartRepository.findCartById(id);
    	if (cartOptional.isEmpty()) {
    		throw new IllegalStateException("Cart does not exist!");
    	}
    	Cart cart = cartOptional.get();
		cart.setStatus(status);
		cart.setTotalPay(totalPay);
		cart.setPurchaseDate(purchaseDate);
	}


	@Transactional
	public void addItem(Long id, Long prod) {
		Optional<Cart> cartOptional = cartRepository.findCartById(id);
    	if (cartOptional.isEmpty()) {
    		throw new IllegalStateException("Cart does not exist!");
    	}
    	
    	Cart cart = cartOptional.get();
  
		Product product = productService.getProductById(prod);
		
		cart.getProducts().add(product);
	}


	@Transactional
	public void removeItem(Long id, Long prod) {
		Optional<Cart> cartOptional = cartRepository.findCartById(id);
    	if (cartOptional.isEmpty()) {
    		throw new IllegalStateException("Cart does not exist!");
    	}
    	
    	Cart cart = cartOptional.get();
    	    	
    	cart.getProducts().removeIf((e)-> e.getId() == prod);
	}

	
	@Transactional
	public void removeAll(Long id) {
		Optional<Cart> cartOptional = cartRepository.findCartById(id);
    	if (cartOptional.isEmpty()) {
    		throw new IllegalStateException("Cart does not exist!");
    	}
    	
    	Cart cart = cartOptional.get();
    	
    	cart.getProducts().clear();
	}
	
	
	
	


}
