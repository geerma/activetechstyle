package course.ensf607.assignment6.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @GetMapping(path = "/category/")
    public List<Product> getProductsByCategory(@RequestParam String category) {
		return productService.getProductsByCategory(category);
    }
    
    
    @GetMapping(path = "/category/{id}")
    public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
    }
    
    
    
    
}