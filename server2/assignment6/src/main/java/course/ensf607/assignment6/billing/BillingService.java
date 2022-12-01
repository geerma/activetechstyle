package course.ensf607.assignment6.billing;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import course.ensf607.assignment6.customer.Customer;
import course.ensf607.assignment6.customer.CustomerRepository;
import course.ensf607.assignment6.customer.CustomerService;

@Service
public class BillingService {

    private final BillingRepository billingRepository;
	private final CustomerRepository customerRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository, CustomerRepository customerRepository) {
        this.billingRepository = billingRepository;
		this.customerRepository = customerRepository;
    }
    
    
	public void addNewBilling(Billing billing) {
		
		Optional<Billing> billingById = billingRepository.findBillingById(billing.getId());
		if (billingById.isPresent()) {
			throw new IllegalStateException("Billing already exist!");
		}
		
		billingRepository.save(billing);
	}
	
    
    public Billing getBillingById(Long billingId) {
        Optional<Billing> billingById = billingRepository.findBillingById(billingId);
        if (billingById.isEmpty()) {
            throw new IllegalStateException("Billing doesn't exist!");
        }
        return billingById.get();
    }
    
    
	public List<Billing> getAllBillings() {
		return billingRepository.findAll();
	}
	
	
	

    @Transactional
	public void updateBilling(Long id, Long cardNumber, Date expiryDate, Integer cvcNumber) {
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



	@Transactional
    public Billing attachBillingToCustomer(Long customerId, Long billingId) {
    	Optional<Customer> customerOptional = customerRepository.findCustomerById(customerId);
    	if (customerOptional.isEmpty()) {
    		throw new IllegalStateException("Customer does not exist!");
    	}
		Customer customer = customerOptional.get();

		Optional<Billing> billingOptional = billingRepository.findBillingById(billingId);
    	if (customerOptional.isEmpty()) {
    		throw new IllegalStateException("Billing does not exist!");
    	}
    	Billing billing = billingOptional.get();

    	billing.setCustomer(customer);

		return billing;
    }




}
