package course.ensf607.assignment6.cart;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import course.ensf607.assignment6.customer.Customer;
import course.ensf607.assignment6.product.Product;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    private Long id;

    private String status = "pending";

    private BigDecimal total = BigDecimal.ZERO;

    @JsonIgnore
    @OneToOne(mappedBy = "cart")
    private Customer customer;

    // @JsonIgnore
    // @ManyToMany
    // @JoinTable(
    //         name = "products_attached",
    //         joinColumns = @JoinColumn(name = "cart_id"),
    //         inverseJoinColumns = @JoinColumn(name = "product_id")
    // )
    // private Map<Product, Integer> bin = new HashMap<>();

    public Cart() {
    }

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // public Map<Product, Integer> getBin() {
    //     return bin;
    // }

    // public void setBin(Map<Product, Integer> bin) {
    //     this.bin = bin;
    // }

    // public void addProduct(Product product, int x) {
    //     // add x of item ( works for new items too )
    //     bin.put(product, bin.getOrDefault(product, 0) + x);
    //     total = total.add(product.getPrice().multiply(BigDecimal.valueOf(x)));
    // }

}