package course.ensf607.assignment6.billing;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/billing/")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    
    @GetMapping(path = "byId/{id}")
    public Billing getBillingById(@PathVariable Long id) {
		return billingService.getBillingById(id);
    }
    
    @GetMapping(path= "all/")
    public List<Billing> getAllBilling () {
    	return billingService.getAllBillings();
    }
    

    @PostMapping
    public void registerNewBilling(@RequestBody Billing billing) {
        billingService.addNewBilling(billing);
    }

    
    @PutMapping(path="{billingId}")
    public void updateBilling(  
    		@PathVariable("billingId") Long id,
			@RequestParam(required= true) Long cardNumber,
			@RequestParam(required= true) Date expiryDate,
			@RequestParam(required= true) Integer cvcNumber) {
    	
        billingService.updateBilling(id, cardNumber, expiryDate, cvcNumber);
    }

    
    
//    @PutMapping("{billingId}/customer/{customerId}")
//    public Billing attachBillingToCustomer(@PathVariable Long billingId,
//                                         @PathVariable Long customerId) {
//        Billing billing = billingService.getBillingById(billingId);
//        Customer customer = customerService.getCustomerById(customerId);
//        billing.addCustomer(customer);
//        billingService.updateBilling(billing);
//        return billing;
//    }
    
    
    
}
