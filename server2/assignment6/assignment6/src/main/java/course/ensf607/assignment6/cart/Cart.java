package course.ensf607.assignment6.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import course.ensf607.assignment6.product.Product;


public class Cart implements Serializable {

    private String status = "pending"; // "checkedout"

    private BigDecimal total = BigDecimal.ZERO;

    private Map<Product, Integer> bin = new HashMap<>();

    
    public void addProduct(Product product) {
        bin.putIfAbsent(product, bin.getOrDefault(product, 1));
        total = total.add(product.getPrice().multiply(BigDecimal.valueOf(1)));
    }			
    
    
    // increase/decrease by 1, though like a +- button
    public void changeQuantity(Product product, String method) {
    	Integer oldQuantity = bin.get(product);
    	Integer newQuantity = oldQuantity;
    	
    	if(method.equals("increase")) {
    		newQuantity += 1;
    	}
    	else if (method.equals("decrease")) {
    		if (oldQuantity-1 > 0)
    			newQuantity -= 1;
    	}
    	
        bin.replace(product, oldQuantity, newQuantity);
        BigDecimal oldAmount = product.getPrice().multiply(BigDecimal.valueOf(oldQuantity));
        BigDecimal newAount = product.getPrice().multiply(BigDecimal.valueOf(newQuantity));

        total = total.subtract(oldAmount);
        total = total.add(newAount);
    }
    
    
    public void removeProduct(Product product) {
        BigDecimal amount = product.getPrice().multiply(BigDecimal.valueOf(bin.get(product)));
    	bin.remove(product);
    	total = total.subtract(amount);
    }
    
    
    public void emptyCart() {
    	bin.clear();
    	total = BigDecimal.valueOf(0);
    }


    
    
    
    
    
    

}