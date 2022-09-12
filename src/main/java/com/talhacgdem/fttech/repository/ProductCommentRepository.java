package com.talhacgdem.fttech.repository;

import com.talhacgdem.fttech.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {

    List<ProductComment> findByCustomer(Integer customerId);

    @Query(value = "SELECT * FROM productcomment WHERE customer_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<ProductComment> findByCustomerByDateDateBetween(Integer customerId, LocalDateTime date1, LocalDateTime date2);

    @Query(value = "SELECT * FROM productcomment WHERE product_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<ProductComment> getCommentsBetweenTwoDatesForProduct(Integer productId, LocalDateTime date1, LocalDateTime date2);

    List<ProductComment> findByProduct(Integer productId);
}
