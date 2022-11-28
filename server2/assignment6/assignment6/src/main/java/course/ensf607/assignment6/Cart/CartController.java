package course.ensf607.assignment6.Cart;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/cart/")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	
	@GetMapping(path = "byId/{id}")
    public Cart getCartById(@PathVariable Long id) {
		return cartService.getCartById(id);
    }
	
	@GetMapping(path= "all/")
    public List<Cart> getAllCarts () {
    	return cartService.getAllCarts();
    }
	
	@PostMapping
    public void registerNewCart(@RequestBody Cart cart) {
		cartService.addNewCart(cart);
    }
	
    @PutMapping(path="{cartId}")
    public void updateCart(  
    		@PathVariable("cartId") Long id,
			@RequestParam(required= true) String status,
			@RequestParam(required= true) BigDecimal totalPay,
			@RequestParam(required= true) Date purchaseDate) {
    	
    	cartService.updateCart(id, status, totalPay, purchaseDate);
    }
    
    
    
//	@GetMapping
//	public Cart addTocart(@RequestBody Product product) {
//		cart.addProduct(product);
//		return cart;
//	}
//
//	@GetMapping
//	public Cart quantityChange(@RequestBody Product product, String method) {
//		cart.changeQuantity(product, method);
//		return cart;
//	}
//
//	@GetMapping
//	public Cart removeFromcart(@RequestBody Product product) {
//		cart.removeProduct(product);
//		;
//		return cart;
//	}
//
//	@GetMapping
//	public Cart emptycart() {
//		cart.emptyCart();
//		;
//		return cart;
//	}
	    
	
}
