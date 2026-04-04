package com.example.t2410e.controller;

import com.example.t2410e.entity.Product;
import com.example.t2410e.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ){
        try {
            return ResponseEntity.ok(productService.filter(name,minPrice,maxPrice));
        }catch (Exception e){
            return ResponseEntity.ofNullable(null);
        }
    }

}
