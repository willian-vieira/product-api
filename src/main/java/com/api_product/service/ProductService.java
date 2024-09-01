package com.api_product.service;

import com.api_product.dto.ProductDTO;
import com.api_product.entities.Product;
import com.api_product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    /**
     * Recupera Lista de Produtos
     * @return List ProductDTO
     */
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
            .stream()
            .map(ProductDTO::convertToProductDTO)
            .collect(Collectors.toList());
    }

    /**
     * Recupera Lista de Produtos por uma Categoria especifica
     * @param categoryId
     * @return List ProductDTO
     */
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
            .stream()
            .map(ProductDTO::convertToProductDTO)
            .collect(Collectors.toList());
    }

    /**
     * Recupera Produto por um Identificador
     * @param productIdentifier
     * @return
     */
    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convertToProductDTO(product);
        }
        return null;
    }

    /**
     * Cria um Produto
     * @param productDTO
     * @return ProductDTO
     */
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productRepository.save(Product.convertToProduct(productDTO));
        if (product != null) {
            return ProductDTO.convertToProductDTO(product);
        }
        return null;
    }

    /**
     * Deleta um Produto por ID
     * @param productId
     */
    public void deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(p -> productRepository.delete(p));
    }
}
