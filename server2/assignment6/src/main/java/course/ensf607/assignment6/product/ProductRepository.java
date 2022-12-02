package course.ensf607.assignment6.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query( value = "SELECT p FROM Product p WHERE p.category = ?1") 
	List<Product> findProductsByCategory(String category);

	@Query( value = "SELECT p FROM Product p WHERE p.id = ?1") 
    Optional<Product> findProductById(Long id);
	
	@Query( value = "SELECT p FROM Product p WHERE p.name LIKE ?1 ORDER bY name") 
    List<Product> findProductByName(String name);

	@Query( value = "SELECT p FROM Product p ORDER BY PRICE ASC") 
	List<Product> findProductSortByPriceAsc();

	@Query( value = "SELECT p FROM Product p ORDER BY PRICE DESC") 
	List<Product> findProductSortByPriceDesc();

}