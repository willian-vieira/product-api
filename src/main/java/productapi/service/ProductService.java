package productapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productapi.dto.ProductDTO;
import productapi.model.Product;
import productapi.repository.IProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
            .stream()
            .map(ProductDTO::convertToProductDTO)
            .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
            .stream()
            .map(ProductDTO::convertToProductDTO)
            .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convertToProductDTO(product);
        }
        return null;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        try {
            Product product = productRepository.save(Product.convertToProduct(productDTO));
            return ProductDTO.convertToProductDTO(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(value -> productRepository.delete(value));
    }
}
