package poly.edu.DATN.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.DATN.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Query(value = "select * from product", nativeQuery = true)
	List<Product> listProduct();
}
