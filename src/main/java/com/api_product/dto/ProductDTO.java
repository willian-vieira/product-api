package com.api_product.dto;

import com.api_product.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    @NotBlank
    private String name;
    @NotNull
    private Float price;
    @NotNull
    private CategoryDTO categoryDTO;
    @NotBlank
    private String description;
    @NotBlank
    private String productIdentifier;

    public static ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convertToCategoryDTO(product.getCategory()));
        }
        return productDTO;
    }
}
