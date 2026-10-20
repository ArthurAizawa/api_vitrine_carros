package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CarroEntity;
import com.example.demo.exception.CarroNaoEncontrado;
import com.example.demo.repository.CarroRepository;

@Service 
public class CarroService {
    @Autowired 
    private CarroRepository repository;

    public List<CarroEntity> listarCarro(){
       return repository.findAll();
    }

    public CarroEntity buscarPorId(Long id){
        return repository.findById(id).orElseThrow(()->new CarroNaoEncontrado(id));
    }

    public CarroEntity cadastrarCarro(CarroEntity carro){
        return repository.save(carro);
    }

    public CarroEntity atualizarCarro(Long id, CarroEntity carro){
        CarroEntity carroExistente = repository.findById(id).orElseThrow(() -> new CarroNaoEncontrado(id));
        if(carroExistente == null)
            return null;

        carroExistente.setMarca(carro.getMarca());
        carroExistente.setNome(carro.getNome());
        carroExistente.setAno(carro.getAno());
        carroExistente.setPreco(carro.getPreco());
        return repository.save(carroExistente);
    }

    public void excluirCarro(Long id){
        repository.findById(id).orElseThrow(()-> new CarroNaoEncontrado(id));
        repository.deleteById(id);
    }
}
