package com.example.t2410e.dto.product;

import com.example.t2410e.dto.category.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private String description;
//    private CategoryResponse category;
}
