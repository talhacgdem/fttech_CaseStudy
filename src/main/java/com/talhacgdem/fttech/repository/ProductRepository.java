package com.talhacgdem.fttech.repository;

import com.talhacgdem.fttech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE lastDate < ?1", nativeQuery = true)
    public List<Product> findExpiredProducts(Date now);

    @Query(value = "SELECT * FROM product WHERE lastDate >= ?1 OR lastDate=null", nativeQuery = true)
    public List<Product> findNotExpiredProducts(Date now);
}
