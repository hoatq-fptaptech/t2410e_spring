package com.example.t2410e.service;

import com.example.t2410e.entity.Product;
import com.example.t2410e.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> filter(String name, Double min, Double max){
        return productRepository.filter(name,min,max);
    }
}
