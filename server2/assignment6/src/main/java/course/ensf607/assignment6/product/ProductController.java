package course.ensf607.assignment6.product;

import java.math.BigDecimal;
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
@RequestMapping(path = "api/v1/product/")
public class ProductController {

    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    
    @GetMapping(path = "byCategory/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
		return productService.getProductsByCategory(category);
    }
    
    
    @GetMapping(path = "byId/{id}")
    public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
    }
    
    @GetMapping(path = "byName/{name}")
    public List<Product> getProductssByName(@PathVariable String name) {
		return productService.getProductByName(name);
    }
    
    @GetMapping(path= "all/")
    public List<Product> getAllProducts () {
    	return productService.getAllProducts();
    }

    @GetMapping(path= "all/price/{ascdesc}")
    public List<Product> getAllProductsSortByPrice(@PathVariable String ascdesc) {
      if (ascdesc.equals("asc")) {
        return productService.getAllProductsSortByPriceAsc();
      } else {
        return productService.getAllProductsSortByPriceDesc();
      }
    }
    
    @PostMapping
    public void registerNewProduct(@RequestBody Product product) {
    	productService.addNewProduct(product);
    }

    
    @PutMapping(path="{productId}")
    public void updateProduct(  
    		@PathVariable("productId") Long id,
			@RequestParam(required= true) String name,
			@RequestParam(required= true) String category,
			@RequestParam(required= true) Double rating,
			@RequestParam(required= true) BigDecimal price,
			@RequestParam(required= true) String image,
			@RequestParam(required= true) Integer stockQuantity,
			@RequestParam(required= true) String stockLocation,
			@RequestParam(required= true) String description) {
    	
        productService.updateProduct(id, name, category, rating, price, image, stockQuantity, stockLocation, description);
    }
    

}