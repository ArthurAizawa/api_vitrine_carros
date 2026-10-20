package com.example.demo.exception;

public class CarroNaoEncontrado extends RuntimeException{
    public CarroNaoEncontrado(Long id){
        super("Carro nao encontrado: " + id);
    }
}
