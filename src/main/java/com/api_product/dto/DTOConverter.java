package com.api_product.dto;

import com.api_product.entities.Category;
import com.api_product.entities.Product;

public class DTOConverter {
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(convert(product.getCategory()));
        }
        productDTO.setDescription(product.getDescription());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        return productDTO;
    }
}