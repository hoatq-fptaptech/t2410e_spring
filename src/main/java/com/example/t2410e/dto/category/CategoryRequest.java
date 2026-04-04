package com.example.t2410e.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryRequest {
    @NotBlank(message = "Please enter name")
    private String name;
}
