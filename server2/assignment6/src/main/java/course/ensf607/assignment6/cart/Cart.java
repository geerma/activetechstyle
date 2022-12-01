package course.ensf607.assignment6.cart;

import course.ensf607.assignment6.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import course.ensf607.assignment6.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "cart")
public class Cart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
	private Long id;

	// @JoinColumn(name="customer_id", nullable=false)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
    private String status ; // "checkedout"

    private BigDecimal totalPay;
    
    private Date purchaseDate;

		// OPTION 1
	// @ManyToMany(mappedBy = "bin")
	// private Map<Product, Integer> bin = new HaswhMap<>();

		// OPTION 2
	// @ElementCollection
	// @CollectionTable(name = "quantities", 
    // 	joinColumns = @JoinColumn(name = "cart_id"))
	// @MapKeyJoinColumn(name = "product_id")
	// @Column(name = "count")
	// private Map<Product, Integer> quantity;

		// OPTION 3
	// @OneToMany(mappedBy="cart")
	// @MapKey(name="cart")
	// public Map<Product, Integer> getProducts() { return products; }
	// public void setOrders(Map<Product, Integer> products) { this.products = products; }
	// private Map<Product, Integer> products;

		//OPTION 4
	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// private List<Product> products = new ArrayList<>();

		//OPTION 5
	// @OneToMany
	// private Set<Product> products;

	@ManyToMany
    @JoinTable(
            name = "cart_contents",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
	private Set<Product> products;
    
	public Cart(Long id, Customer customer, String status, BigDecimal totalPay, Date purchaseDate) {
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.totalPay = totalPay;
		this.purchaseDate = purchaseDate;
	} 
	
    
	public Cart(Customer customer, String status, BigDecimal totalPay, Date purchaseDate) {
		this.customer = customer;
		this.status = status;
		this.totalPay = totalPay;
		this.purchaseDate = purchaseDate;
	}

	

		// OPTION 2
	// public void addProduct(Product product, int num) {
	// 	quantity.put(product, num);
	// }
	
			// OPTION 3
	// public void addProduct(Product product, int num) {
	// 	products.put(product, num);
	// }

	public Cart(Customer customer, Set<Product> products) {
		this.customer = customer;
		this.products = products;
		purchaseDate = new Date(System.currentTimeMillis());
		this.status = "True";
		updatePrice(products);
	}


	// OPTION 4 & 5
	public void addProduct(Product product) {
		products.add(product);
		updatePrice();
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
		updatePrice();
	}

	public void updatePrice() {
		totalPay = BigDecimal.ZERO;
		for (Product product : products) {
			totalPay = totalPay.add(product.getPrice());
		}
	}

	public void updatePrice(Set<Product> products) {
		totalPay = BigDecimal.ZERO;
		for (Product product : products) {
			totalPay = totalPay.add(product.getPrice());
		}
	}

	public void empty() {
		products.clear();
		updatePrice();
	}
    

    
    
//    private Map<Product, Integer> bin = new HashMap<>();
//
//    
//    public void addProduct(Product product) {
//        bin.putIfAbsent(product, bin.getOrDefault(product, 1));
//        totalPay = totalPay.add(product.getPrice().multiply(BigDecimal.valueOf(1)));
//    }			
//    
//    
//    // increase/decrease by 1, though like a +- button
//    public void changeQuantity(Product product, String method) {
//    	Integer oldQuantity = bin.get(product);
//    	Integer newQuantity = oldQuantity;
//    	
//    	if(method.equals("increase")) {
//    		newQuantity += 1;
//    	}
//    	else if (method.equals("decrease")) {
//    		if (oldQuantity-1 > 0)
//    			newQuantity -= 1;
//    	}
//    	
//        bin.replace(product, oldQuantity, newQuantity);
//        BigDecimal oldAmount = product.getPrice().multiply(BigDecimal.valueOf(oldQuantity));
//        BigDecimal newAount = product.getPrice().multiply(BigDecimal.valueOf(newQuantity));
//
//        totalPay = totalPay.subtract(oldAmount);
//        totalPay = totalPay.add(newAount);
//    }
//    
//    
//    public void removeProduct(Product product) {
//        BigDecimal amount = product.getPrice().multiply(BigDecimal.valueOf(bin.get(product)));
//    	bin.remove(product);
//    	totalPay = totalPay.subtract(amount);
//    }
//    
//    
//    public void emptyCart() {
//    	bin.clear();
//    	totalPay = BigDecimal.valueOf(0);
//    }
//
//
//	public void emptyCart() {
//		// TODO Auto-generated method stub
//		
//	}
//

    
    
    
    
    
    

}