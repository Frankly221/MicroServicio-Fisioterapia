package com.Citas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Citas.Entity.EstadoCita;
import com.Citas.Repositorio.EstadoCitaRepo;

@Service
public class EstadoCitaService {


    @Autowired
    private EstadoCitaRepo estadoCitaRepo;

    public List<EstadoCita> getall(){
        return estadoCitaRepo.findAll();
    }

    public Optional<EstadoCita> getOne(int id){
        return estadoCitaRepo.findById(id); 
    }
    
    public EstadoCita save(EstadoCita estadoCita){
        return estadoCitaRepo.save(estadoCita);

    }

    public EstadoCita editar(int id , EstadoCita estadoCita){
        EstadoCita estadoup = new EstadoCita();

        estadoup.setNombre_estado(estadoCita.getNombre_estado());

        return estadoCitaRepo.save(estadoup);

    }

    public void delete(int id){

        estadoCitaRepo.deleteById(id);
    }













}
