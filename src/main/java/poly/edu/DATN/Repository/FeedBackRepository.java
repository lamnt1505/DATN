package poly.edu.DATN.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.edu.DATN.Entity.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{
    
    @Query(value = "select * from feedback", nativeQuery = true)
    List<FeedBack> listFeedBack();
}
