package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CarroRequest(
    @NotBlank String nome,
    @NotBlank String marca, 
    @NotNull @Positive Double preco,
    @NotNull @Min(1900) Integer ano
){   
}
