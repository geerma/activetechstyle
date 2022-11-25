package course.ensf607.assignment6.customer;

import course.ensf607.assignment6.billing.*;
import course.ensf607.assignment6.cart.Cart;

// import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;

    private String name;

    private String email;

    private String password;

    // @JsonIgnore
    @ManyToMany(mappedBy = "attachedCustomers")
    private Set<Billing> payMethods = new HashSet<>();

    // @OneToMany(mappedBy = "customer")
    // private Set<Cart> purchaseHistory = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String password, Set<Billing> payMethods) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.payMethods = payMethods;
        // this.cart = new Cart();
    }

    public Customer(String name, String email, String password, Set<Billing> payMethods) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.payMethods = payMethods;
        // this.cart = new Cart();
    }

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Billing> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(Set<Billing> payMethods) {
        this.payMethods = payMethods;
    }

    public void addPayMethod(Billing billing) {
        payMethods.add(billing);
    }

    // public PurchaseHistory getHistory() {
    //     return history;
    // }

    // public Customer setHistory(PurchaseHistory history) {
    //     this.history = history;
    //     return this;
    // }

    public Cart getCart() {
        return cart;
    }

    public Customer setCart(Cart cart) {
        this.cart = cart;
        return this;
    }

    
}

