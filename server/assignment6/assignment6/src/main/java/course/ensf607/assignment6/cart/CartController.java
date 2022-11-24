package course.ensf607.assignment6.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import course.ensf607.assignment6.customer.Customer;
import course.ensf607.assignment6.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cart")
public class CartController {

    private final CartService cartService;

    private final CustomerService customerService;

    @Autowired
    public CartController(CartService cartService, CustomerService customerService) {
        this.cartService = cartService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Cart> getCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping
    public void registerNewCart(@RequestBody Cart cart) {
        cartService.addNewCart(cart);
    }

    @PutMapping("{cartId}/customer/{customerId}")
    public Cart attachcartToCustomer(@PathVariable Long cartId,
                                         @PathVariable Long customerId) {
        Cart cart = cartService.getCartById(cartId);
        Customer customer = customerService.getCustomerById(customerId);
        cart.setCustomer(customer);
        customer.setCart(cart);
        cartService.updateCart(cart);
        customerService.updateCustomer(customer);
        return cart;
    }
}
