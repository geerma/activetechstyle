package course.ensf607.assignment6.product;

import java.io.Serializable;
import java.math.BigDecimal;
// import java.util.HashSet;
// import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        long temp;
        temp = Double.doubleToLongBits(rating);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + stockQuantity;
        result = prime * result + ((stockLocation == null) ? 0 : stockLocation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (stockQuantity != other.stockQuantity)
            return false;
        if (stockLocation == null) {
            if (other.stockLocation != null)
                return false;
        } else if (!stockLocation.equals(other.stockLocation))
            return false;
        return true;
    }
    
}
