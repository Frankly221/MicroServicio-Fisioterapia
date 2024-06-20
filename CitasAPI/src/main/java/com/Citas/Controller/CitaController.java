package com.Citas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Citas.Entity.Cita;
import com.Citas.Service.CitaService;

@RestController
@RequestMapping(value ="/api/cita")
public class CitaController {
    
    @Autowired
    private CitaService citaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Cita> getAll(){

        return citaService.getAll();
    }

    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<Cita> getOne(@PathVariable("id") int id){

        return citaService.getOne(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public Cita save(@RequestBody Cita cita){

        return citaService.save(cita);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/editar/{id}")
    public Cita editar(@RequestBody Cita cita, @PathVariable("id") int id){

        return citaService.editar(id, cita);
    }

    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") int id){

        citaService.delete(id);
    }


    //Solicitud para ingreso de 2 microservicios
    @GetMapping("/buscar-my-citas/{idpaciente}")
    public ResponseEntity<?> findByIdCita(@PathVariable int idpaciente){

        return ResponseEntity.ok(citaService.findByIdPaciente(idpaciente));

    }


}