package com.example.t2410e.controller;

import com.example.t2410e.common.ResponseHandler;
import com.example.t2410e.dto.common.ResponseDTO;
import com.example.t2410e.entity.Product;
import com.example.t2410e.enums.StatusCode;
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
    public ResponseEntity<ResponseDTO<List<Product>>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ){
        try {
            return ResponseHandler.success(productService.filter(name,minPrice,maxPrice)
                    ,"Ê đã thấy sản phẩm....");
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }

}
