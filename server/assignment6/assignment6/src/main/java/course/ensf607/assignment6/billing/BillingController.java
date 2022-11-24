package course.ensf607.assignment6.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import course.ensf607.assignment6.customer.Customer;
import course.ensf607.assignment6.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/billing")
public class BillingController {

    private final BillingService billingService;

    private final CustomerService customerService;

    @Autowired
    public BillingController(BillingService billingService, CustomerService customerService) {
        this.billingService = billingService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Billing> getBillings() {
        return billingService.getAllBillings();
    }

    @PostMapping
    public void registerNewBilling(@RequestBody Billing billing) {
        billingService.addNewBilling(billing);
    }

    @PutMapping("{billingId}/customer/{customerId}")
    public Billing attachBillingToCustomer(@PathVariable Long billingId,
                                         @PathVariable Long customerId) {
        Billing billing = billingService.getBillingById(billingId);
        Customer customer = customerService.getCustomerById(customerId);
        billing.addCustomer(customer);
        billingService.updateBilling(billing);
        return billing;
    }
}
