//package course.ensf607.assignment6.cart;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import course.ensf607.assignment6.product.Product;
//
//@RestController
//@RequestMapping(path = "api/v1/cart")
//public class CartController {
//
//
//	    private final Cart cart;
//
//	    @Autowired
//	    public CartController(Cart cart) {
//	        this.cart = cart;
//	    }
//
//	    
//	    @GetMapping
//	    public Cart addToCart(@RequestBody Product product) {
//			cart.addProduct(product);
//			return cart;
//	    }
//	    
//	    
//	    @GetMapping
//	    public Cart quantityChange(@RequestBody Product product, String method) {
//			cart.changeQuantity(product, method);
//			return cart;
//	    }
//	    
//	    @GetMapping
//	    public Cart removeFromCart(@RequestBody Product product) {
//			cart.removeProduct(product);;
//			return cart;
//	    }
//	    
//	    @GetMapping
//	    public Cart emptyCart() {
//			cart.emptyCart();;
//			return cart;
//	    }
//	    
//	    
//	
//}
