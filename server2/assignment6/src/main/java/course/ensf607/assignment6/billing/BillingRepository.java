package course.ensf607.assignment6.billing;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

	@Query( value = "SELECT b FROM Billing b WHERE b.id = ?1") 
    Optional<Billing> findBillingById(Long id);
	
	@Query( value = "SELECT b FROM Billing b WHERE b.cardNumber = ?1") 
    Optional<Billing> findBillingByCardNumber(Long cardNumber);

    @Transactional
    // @Query( value = "DELETE Billing b WHERE b.id = ?1")
    void deleteById(Long id);
}
