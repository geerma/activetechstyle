package course.ensf607.assignment6.customer;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import course.ensf607.assignment6.billing.BillingService;
import course.ensf607.assignment6.product.Product;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {  
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/name")
    @ResponseBody
    public Customer getbyName(@RequestBody String name) {
        return customerService.getbyName(name);
    }

    @GetMapping("/id")
    @ResponseBody
    public Customer getCustomerById(@RequestBody Long id) {
        return customerService.getCustomerById(id);
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
    
    
    
    
    @GetMapping(path = "/login")
    @ResponseBody
    public Boolean checkCustomersLogin(@RequestBody String email, @RequestBody String password) {
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
