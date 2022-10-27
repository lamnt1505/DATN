package poly.edu.DATN.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.DATN.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Query(value = "select * from product", nativeQuery = true)
	List<Product> listProduct();
	
    @Query(value = "select * from product where id_category = ?", nativeQuery = true)
    List<Product> showListProductByIdCategoryFilter(int idCategory);
    
    @Query(value = " select top 8 * from product order by id_product desc ", nativeQuery = true)
    List<Product> showListProductForIndex();
}
