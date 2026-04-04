package com.example.t2410e.common;

import com.example.t2410e.dto.common.ResponseDTO;
import com.example.t2410e.enums.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static <T> ResponseEntity<ResponseDTO<T>> success(
            T data, String customMessage
    ){
        ResponseDTO<T> dto = new ResponseDTO<>(
                StatusCode.SUCCESS.getCode(),
                customMessage !=null?customMessage:StatusCode.SUCCESS.getMessage(),
                data
        );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> error(
            StatusCode statusCode, String customMessage
    ){
        ResponseDTO<T> dto = new ResponseDTO<>(
                statusCode.getCode(),
                customMessage !=null?customMessage:StatusCode.SUCCESS.getMessage(),
                null
        );
        return ResponseEntity.status(statusCode.getHttpStatus()).body(dto);
    }
}
