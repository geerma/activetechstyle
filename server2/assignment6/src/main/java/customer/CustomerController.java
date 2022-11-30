package course.ensf607.assignment6.customer;

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
@RequestMapping(path = "api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {  
        this.customerService = customerService;
    }

    @GetMapping(path = "byId/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    
    @GetMapping(path= "byName/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }
    
    
    @GetMapping(path= "all/")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomer();
    }
    
    

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    
    @PutMapping(path="{customerId}")
    public void updateCustomer(  
    		@PathVariable("customerId") Long id,
			@RequestParam(required= true) String name,
			@RequestParam(required= true) String email,
			@RequestParam(required= true) String password) {
    	
        customerService.updateCustomer(id, name, email, password);
    }
    
    
    
    
    @GetMapping(path = "/login/")
    public Customer getProductById(@RequestParam String email, @RequestParam String password ) {
		return customerService.checkCustomerLogin(email, password);
    }
    
    
    
    
//     @PutMapping("{customerId}/billing/{billingId}")
//     public Customer attachBillingToCustomer(@PathVariable Long billingId,
//                                          @PathVariable Long customerId) {
//         Billing billing = billingService.getBillingById(billingId);
//         Customer customer = customerService.getCustomerById(customerId);
//         customer.addPayMethod(billing);
//         customerService.updateCustomer(customer);
//         return customer;
//     }
}
