package com.PacienteAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.PacienteAPI.Entity.Paciente;
import com.PacienteAPI.Service.PacienteServi;

@RequestMapping(value = "/api/paciente")
@CrossOrigin("/**")
@RestController

public class PacienteController {

    @Autowired
    private PacienteServi pacienteServi;


    @ResponseStatus(HttpStatus.OK) 
    @GetMapping("/all")
    public List<Paciente> obtenerTodo(){

        return pacienteServi.getALL();
    }
    @ResponseStatus(HttpStatus.OK)    
    @GetMapping("/one/{id}")
    public Optional<Paciente> obtenerUno( @PathVariable("id") int id){

        return pacienteServi.getOne(id);

    }

    // @GetMapping("/one/{id}")
    // public ResponseEntity<Paciente> obtenerUno(@PathVariable("id") int id) {
    //     Optional<Paciente> paciente = pacienteServi.getOne(id);
    //     if (paciente.isPresent()) {
    //         return ResponseEntity.ok(paciente.get());
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    //     }

    @ResponseStatus(HttpStatus.OK)  
    @PostMapping("/save")
    public Paciente guardar(@RequestBody Paciente paciente){

        return pacienteServi.save(paciente);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/edit/{id}")
    public Paciente editar(@PathVariable("id") int id, @RequestBody Paciente paciente) {
        return pacienteServi.update(id, paciente);
    }


    @DeleteMapping("/delete")
    public void eliminar(@PathVariable("id") int id){

        pacienteServi.delete(id);
    }



    //Conexiones entre microservicios

    @GetMapping("/buscar-paciente/{idpaciente}")
    public ResponseEntity<?> findHcByIdPaciente(@PathVariable int idpaciente){

        return ResponseEntity.ok(pacienteServi.findHcByIdPaciente(idpaciente));

    }


    //Conexiones
    @GetMapping("/buscar-cita/{idpaciente}")
    public ResponseEntity<?> findCitaByIdPaciente(@PathVariable int idpaciente){

        return ResponseEntity.ok(pacienteServi.findCitasByIdPaciente(idpaciente));

    }



    //Encontrar los atributos de paciente segun el n° de cita

    @GetMapping("/buscar-paciente-por-id-cita/{idpac}")
    public ResponseEntity<?> darPacienteByIdPaciente(@PathVariable("idpac") int idpac){
        return ResponseEntity.ok(pacienteServi.findByIdPac(idpac));
    }












    }










