package com.example.t2410e.repository;

import com.example.t2410e.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name); // name = "...."
    List<Product> findByNameContainingAndPriceBetween(
            String name,Double minPrice,Double maxPrice);
    // select * from products where name like '%s%' and price > min and price < max
    //jQL
    @Query("""
        SELECT p from Product p
        WHERE (:name IS NULL OR p.name LIKE %:name%)
        AND (:min IS NULL OR p.price >= :min)
        AND (:max IS NULL OR p.price <= :max)
    """
    )
    List<Product> filter(
                        @Param("name") String name,
                        @Param("min") Double min,
                        @Param("max") Double max
    );
}
