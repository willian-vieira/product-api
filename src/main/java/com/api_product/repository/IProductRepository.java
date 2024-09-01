package com.api_product.repository;

import com.api_product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(
        value = "SELECT p.name, p.price, p.product_identifier, p.description "
              + "FROM Products p  "
              + "JOIN Categories c on p.category_id = c.id  "
              + "WHERE c.id = :categoryId ", nativeQuery = true)
    public List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    Product findByProductIdentifier(String productIdentifier);
}

