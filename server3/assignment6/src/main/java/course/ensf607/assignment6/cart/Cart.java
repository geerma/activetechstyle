package course.ensf607.assignment6.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import course.ensf607.assignment6.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "Cart")
public class Cart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Long id;
	
    private String status ; // "checkedout"

    private BigDecimal totalPay = BigDecimal.ZERO;
    
    private Date purchaseDate;
    
    @Column(length = 3000)
    @ElementCollection(targetClass=Product.class)
    private Set<Product> products;

    
	public Cart(Long id, String status, BigDecimal totalPay, Date purchaseDate) {
		this.id = id;
		this.status = status;
		this.totalPay = totalPay;
		this.purchaseDate = purchaseDate;
	} 
	
    
	public Cart(String status, BigDecimal totalPay, Date purchaseDate) {
		this.status = status;
		this.totalPay = totalPay;
		this.purchaseDate = purchaseDate;
	}


 
    
    

}