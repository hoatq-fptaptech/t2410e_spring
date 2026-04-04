package com.example.t2410e.dto.common;

import com.example.t2410e.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO <T>{
    private String code;
    private String message;
    private T data;

    public ResponseDTO(StatusCode statusCode, T data){
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }
}
