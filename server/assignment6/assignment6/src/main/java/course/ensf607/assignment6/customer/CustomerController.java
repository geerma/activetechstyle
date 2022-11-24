package course.ensf607.assignment6.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import course.ensf607.assignment6.billing.Billing;
import course.ensf607.assignment6.billing.BillingService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final BillingService billingService;

    @Autowired
    public CustomerController(CustomerService customerService, BillingService billingService) {
        this.customerService = customerService;
        this.billingService = billingService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
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
