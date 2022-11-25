package course.ensf607.assignment6.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query( value = "SELECT c FROM Customer c WHERE c.id = ?1") 
    Optional<Customer> findCustomerById(Long id);
	
	@Query( value = "SELECT c FROM Customer c WHERE c.email = ?1") 
    Optional<Customer> findCustomerByEmail(String email);

    @Query( value = "SELECT c FROM Customer c WHERE c.name = ?1") 
    Optional<Customer> findCustomerByName(String name);

    Optional<Customer> findOptional(String name);
}
