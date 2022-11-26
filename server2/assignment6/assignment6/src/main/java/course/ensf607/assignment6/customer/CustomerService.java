package course.ensf607.assignment6.customer;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
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
        if (customerById.isEmpty()) {
            throw new IllegalStateException("Customer does'nt exist!");
        }
        return customerById.get();
    }

    
    

	public Customer getCustomerByName(String name) {
		Optional<Customer> customerByName = customerRepository.findCustomerByName(name);
        if (customerByName.isEmpty()) {
            throw new IllegalStateException("Customer does'nt exist!");
        }
        return customerByName.get();
	}
	
	
    
    
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	
	
    
    @Transactional
    public void updateCustomer(Long id, String name, String email, String password) {
		Optional<Customer> customerOptional = customerRepository.findCustomerById(id);
    	if (customerOptional.isEmpty()) {
    		throw new IllegalStateException("Customer does not exist!");
    	}
    	
    	Customer customer = customerOptional.get();
    		
		if (! email .equals( customer.getEmail() )) {
			Optional<Customer> customerO = customerRepository.findCustomerByEmail(email);
			if (customerO.isPresent()) {
				throw new IllegalStateException("email is already taken!");
			}
			customer.setEmail(email);
		}

		customer.setName(name);

		customer.setPassword(password);

    }


	public Boolean checkCustomerLogin(String email, String password) {
		Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
		if (customerOptional.isEmpty()) {
    		throw new IllegalStateException("Customer does not exist!");
    	}
		
		Customer customer = customerOptional.get();
		
		if(customer.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}





    
    
    
    

    
    
    
    
    
}
