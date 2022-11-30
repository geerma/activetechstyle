package course.ensf607.assignment6.product;

import java.io.Serializable;
import java.math.BigDecimal;
// import java.util.HashSet;
// import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import course.ensf607.assignment6.cart.Cart;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String category;

    private Double rating;

    private BigDecimal price;

    private String image;

    private Integer stockQuantity;

    private String stockLocation;
    
    private String description;

        // OPTION 3 - from Cart.java
    // private Cart number;
    // @ManyToOne
    // private int number;

    
    public Product(String name, String category, Double rating, BigDecimal price, String image, 
    		Integer stockQuantity, String stockLocation, String description) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.stockLocation = stockLocation;
    }

    public Product(Long id, String name, String category, Double rating, BigDecimal price, String image,
    		Integer stockQuantity, String stockLocation) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.stockLocation = stockLocation;
    }
    
}
