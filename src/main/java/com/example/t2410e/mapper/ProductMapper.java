package com.example.t2410e.mapper;

import com.example.t2410e.dto.product.ProductResponse;
import com.example.t2410e.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // entity -> dto
    ProductResponse toResponse(Product product);
    // list entity -> list dto
    List<ProductResponse> toResponseList(List<Product> products);
    // dto request -> entity
}
