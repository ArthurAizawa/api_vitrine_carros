package com.example.demo.dto;

public record CarroResponse(
    Long id,
    String nome,
    String marca,
    Double preco,
    Integer ano
) {

}
