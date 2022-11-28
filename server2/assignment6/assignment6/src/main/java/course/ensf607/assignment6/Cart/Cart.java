package course.ensf607.assignment6.Cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
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
@Table(name = "Cart")
public class Cart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Long id;
	
    private String status ; // "checkedout"

    private BigDecimal totalPay = BigDecimal.ZERO;
    
    private Date purchaseDate;

    
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