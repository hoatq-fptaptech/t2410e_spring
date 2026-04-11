package com.example.t2410e.service;

import com.example.t2410e.dto.product.ProductResponse;
import com.example.t2410e.entity.Product;
import com.example.t2410e.mapper.ProductMapper;
import com.example.t2410e.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public List<ProductResponse> filter(String name, Double min, Double max){
        return productMapper.toResponseList(productRepository.filter(name,min,max));
    }
}
