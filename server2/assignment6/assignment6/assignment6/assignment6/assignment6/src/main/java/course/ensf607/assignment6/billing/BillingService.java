package course.ensf607.assignment6.billing;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.ensf607.assignment6.customer.Customer;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }
    
    
	public void addNewBilling(Billing billing) {
		Optional<Billing> billingById = billingRepository.findBillingById(billing.getId());
		if (billingById.isPresent()) {
			throw new IllegalStateException("Billing already exist!");
		}
		billingRepository.save(billing);
	}
	
    
    public Billing getBillingById(Long billingId) {
        Optional<Billing> billingById = billingRepository.findById(billingId);
        if (!billingById.isPresent()) {
            throw new IllegalStateException("Billing doesn't exist!");
        }
        return billingById.get();
    }

	public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }
    
    @Transactional
	public void updateBilling(Long id, Customer customer, Long cardNumber, Date expiryDate, Integer cvcNumber) {
		Optional<Billing> billingOptional = billingRepository.findBillingById(id);
    	if (billingOptional.isEmpty()) {
    		throw new IllegalStateException("Billing does not exist!");
    	}
    	
    	Billing billing = billingOptional.get();
    		
		if (cardNumber != billing.getCardNumber()) {
			Optional<Billing> billingO = billingRepository.findBillingByCarNumber(cardNumber);
			if (billingO.isPresent()) {
				throw new IllegalStateException("Card number is already taken!");
			}
			billing.setCardNumber(cardNumber);
		}
		
		billing.setExpiryDate(expiryDate);

		billing.setCvcNumber(cvcNumber);
		
    	
	}


}
