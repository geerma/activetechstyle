package course.ensf607.assignment6.cart;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import course.ensf607.assignment6.customer.Customer;
import course.ensf607.assignment6.customer.CustomerService;
import course.ensf607.assignment6.product.Product;
import course.ensf607.assignment6.product.ProductService;
import course.ensf607.assignment6.utility.LongList;

@RestController
@RequestMapping(path = "api/v1/cart/")
public class CartController {

	private final CartService cartService;

	private final CustomerService customerService;

	private final ProductService productService;

	@Autowired
	public CartController(CartService cartService, CustomerService customerService, ProductService productService) {
		this.productService = productService;
		this.customerService = customerService;
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

    @PostMapping(path="customer/{customerId}")
    public Customer registerNewCartToCustomer(@PathVariable Long customerId,
                                            @RequestBody LongList productIds) {
        Set<Product> products = new HashSet<>();
        List<Long> ids = productIds.getData();
        for (int i = 0; i < ids.size(); i++) {
            Product product = productService.getProductById(ids.get(i));
            products.add(product);
        }
        Customer customer = customerService.getCustomerById(customerId);
        Cart cart = new Cart(customer, products);
		cartService.addNewCart(cart);
        return customer;
    }
	
    @PutMapping(path="{cartId}")
    public void updateCart(  
    		@PathVariable("cartId") Long id,
			@RequestParam(required= true) String status,
			@RequestParam(required= true) BigDecimal totalPay,
			@RequestParam(required= true) Date purchaseDate) {
    	
    	cartService.updateCart(id, status, totalPay, purchaseDate);
    }
    
	@PutMapping(path= "{cartId}/customer/{customerId}")
    public Cart enrollCustomerToCart(@PathVariable Long cartId,
                                         @PathVariable Long customerId) {
        Cart cart = cartService.getCartById(cartId);
        Customer customer = customerService.getCustomerById(customerId);
        cart.setCustomer(customer);
        cartService.updateCart(cart);
        return cart;
    }

	@PutMapping(path= "{cartId}/addProduct/{productId}")
    public Cart addProductToCart(@PathVariable Long cartId,
                                         @PathVariable Long productId) {
        Cart cart = cartService.getCartById(cartId);
        Product product = productService.getProductById(productId);
        cart.addProduct(product);
        cartService.updateCart(cart);
        return cart;
    }

    @PutMapping(path= "{cartId}/addProductsById/")
    public Cart addProductsToCart(@PathVariable Long cartId,
                                    @RequestBody(required= true) LongList productIds) {
        Cart cart = cartService.getCartById(cartId);
        List<Long> products = productIds.getData();
        for (int i = 0; i < products.size(); i++) {
            Product product = productService.getProductById(products.get(i));
            cart.addProduct(product);
        }
        cartService.updateCart(cart);
return cart;
    }

    @PutMapping(path= "{cartId}/addProducts/")
    public Cart addProductsToCart(@PathVariable Long cartId,
                                    @RequestBody(required= true) List<Product> products) {
        Cart cart = cartService.getCartById(cartId);
        for (int i = 0; i < products.size(); i++) {
            Product product = productService.getProductById(products.get(i).getId());
            cart.addProduct(product);
        }
        cartService.updateCart(cart);
return cart;
    }

    @PutMapping(path= "{cartId}/removeProduct/{productId}")
    public Cart removeProductFromCart(@PathVariable Long cartId,
                                         @PathVariable Long productId) {
        Cart cart = cartService.getCartById(cartId);
        Product product = productService.getProductById(productId);
        cart.removeProduct(product);
        cartService.updateCart(cart);
        return cart;
    }

    @PutMapping(path= "{cartId}/emptyCart/")
    public Cart removeProductFromCart(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cart.empty();
        cartService.updateCart(cart);
        return cart;
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
