package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CarroEntity;
import com.example.demo.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    public List<CarroEntity> listar() {
        return service.listarCarro();
    }

    @GetMapping("/{id}")
    public CarroEntity getMethodName(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CarroEntity cadastrarCarro(@RequestBody CarroEntity carro) {
        return service.cadastrarCarro(carro);
    }

    @PutMapping("/{id}")
    public CarroEntity atualizarCarro(
            @PathVariable Long id, 
            @RequestBody CarroEntity carro) {

        return service.atualizarCarro(id, carro);
    }

    @DeleteMapping ("/{id}")
    public void deletarCarro(@PathVariable Long id){
        service.excluirCarro(id);
    }

}
