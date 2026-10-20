package com.example.demo.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class GlobalException {
    @ExceptionHandler(CarroNaoEncontrado.class)
    public ResponseEntity<Map<String, String>> handle(CarroNaoEncontrado e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("erro", e.getMessage()));

    }

}