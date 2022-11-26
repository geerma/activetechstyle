package course.ensf607.assignment6.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    // (path = "/category")
    // @GetMapping
    // public List<Product> getProductsByCategory(@RequestBody String category) {
		// return productService.getProductsByCategory(category);
    // }
    
    
    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
    }
    
    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }
    
    @GetMapping
    public List<Product> getAllProducts () {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/category/{category}")
    public List<Product> getProductById(@PathVariable String category) {
		return productService.getProductsByCategory(category);
    }
}