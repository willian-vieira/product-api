package productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import productapi.model.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(
        value =  "SELECT p.name, p.price, "
        + "p.productIdentifier, p.description "
        + "FROM Product p "
        + "JOIN Category c on p.category.id = c.id "
        + "WHERE c.id = :categoryId "
    )
    public List<Product> getProductByCategory(@Param("categoryId") Long categoryId);

    public Product findByProductIdentifier(String productIdentifier);
}
