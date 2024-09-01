package com.api_product.controller;

import com.api_product.dto.ProductDTO;
import com.api_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String get() {
        return "API Running! 🚀";
    }

    @GetMapping("/products")
    public List<ProductDTO> findListProducts() {
        List<ProductDTO> products = this.productService.getAllProducts();
        return products;
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> findProductByCategoryId(@PathVariable Long categoryId) {
        List<ProductDTO> products = this.productService.getProductByCategoryId(categoryId);
        return products;
    }

    @GetMapping("product/{productIdentifier}")
    ProductDTO findProductById(@PathVariable String productIdentifier) {
        return this.productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.createProduct(productDTO);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }

}
