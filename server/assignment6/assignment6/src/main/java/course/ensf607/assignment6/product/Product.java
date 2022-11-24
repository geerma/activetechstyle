package course.ensf607.assignment6.product;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
// import java.util.HashSet;
// import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    private String name;

    private String category;

    private double rating;

    private BigDecimal price;

    private String image;

    private int stockQuantity;

    private String stockLocation;

    public Product() {
    }
    
    public Product(String name, String category, double rating, BigDecimal price, String image, int stockQuantity,
            String stockLocation) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.stockLocation = stockLocation;
    }

    public Product(Long id, String name, String category, double rating, BigDecimal price, String image,
            int stockQuantity, String stockLocation) {
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

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Product setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Product setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public String getStockLocation() {
        return stockLocation;
    }

    public Product setStockLocation(String stockLocation) {
        this.stockLocation = stockLocation;
        return this;
    }

}
