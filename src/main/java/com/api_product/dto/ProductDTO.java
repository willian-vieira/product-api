package com.api_product.dto;

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
    @NotBlank
    private String description;
    @NotBlank
    private String productIdentifier;
}
