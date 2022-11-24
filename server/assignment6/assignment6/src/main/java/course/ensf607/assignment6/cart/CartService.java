package course.ensf607.assignment6.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
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

    public Cart getCartById(Long cartId) {
        Optional<Cart> cartById = cartRepository.findById(cartId);
        if (!cartById.isPresent()) {
            throw new IllegalStateException("Cart doesn't exist!");
        }
        return cartById.get();
    }

    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }
}
