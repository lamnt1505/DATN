package poly.edu.DATN.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.DATN.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM users  WHERE phone = ?", nativeQuery = true)
	Optional<User> findByPhone(String phone);
	
}
