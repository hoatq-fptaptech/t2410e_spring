package com.example.t2410e.controller;

import com.example.t2410e.common.ResponseHandler;
import com.example.t2410e.dto.auth.RegisterReq;
import com.example.t2410e.dto.common.ResponseDTO;
import com.example.t2410e.enums.StatusCode;
import com.example.t2410e.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    public final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Boolean>> register(
            @RequestBody RegisterReq req){
        try {
            return ResponseHandler.success(
                    authService.register(req),"Register successfully");
        }catch (Exception e){
            return ResponseHandler.error(StatusCode.BAD_REQUEST,e.getMessage());
        }
    }
}
