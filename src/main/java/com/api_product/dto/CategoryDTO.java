package com.api_product.dto;

import com.api_product.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String name;

    public static CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(categoryDTO.getName());
        return categoryDTO;
    }
}
