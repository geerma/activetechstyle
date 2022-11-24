package course.ensf607.assignment6.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerById = customerRepository.findCustomerById(customer.getId());
        if (customerById.isPresent()) {
            throw new IllegalStateException("Customer already exist!");
        }
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customerById = customerRepository.findById(customerId);
        if (!customerById.isPresent()) {
            throw new IllegalStateException("Customer does'nt exist!");
        }
        return customerById.get();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
