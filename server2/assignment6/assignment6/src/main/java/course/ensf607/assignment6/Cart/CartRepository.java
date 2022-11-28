package course.ensf607.assignment6.cart;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query( value = "SELECT o FROM Cart o WHERE o.id = ?1") 
    Optional<Cart> findCartById(Long id);
	
	@Query( value = "SELECT o FROM Cart o WHERE o.purchaseDate = ?1") 
    Optional<Cart> findCartByDate(Date purchaseDate);
}
