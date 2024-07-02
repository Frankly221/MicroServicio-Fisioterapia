package com.Citas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Citas.Entity.EstadoCita;
import com.Citas.Service.EstadoCitaService;

@RestController
@RequestMapping(value = "/api/estadocita")
@CrossOrigin("/**")

public class EstadoCitaController {

    @Autowired
    private EstadoCitaService estadoCitaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<EstadoCita> getAll(){
        return estadoCitaService.getall();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<EstadoCita> getOne(@PathVariable("id") int id){

        return estadoCitaService.getOne(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public EstadoCita save(@RequestBody EstadoCita estadoCita){

        return estadoCitaService.save(estadoCita);

    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/editar/{id}")
    public EstadoCita editar(@PathVariable("id") int id, @RequestBody EstadoCita estadoCita){

        return estadoCitaService.editar(id,estadoCita);
    }



    
}
