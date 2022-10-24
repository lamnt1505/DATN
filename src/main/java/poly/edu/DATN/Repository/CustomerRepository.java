package poly.edu.DATN.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.DATN.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "SELECT * FROM customers  WHERE phone = ?", nativeQuery = true)
	Optional<Customer> findByPhoneCus(String phone);
}
