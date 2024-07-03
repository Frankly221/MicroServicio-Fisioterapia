package com.Citas.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.Citas.Entity.Cita;
import com.Citas.Http.Response.PacienteByIdCita;
import com.Citas.Service.CitaService;

@RestController
@RequestMapping(value = "/api/cita")
@CrossOrigin("/**")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Cita> getAll() {

        return citaService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<Cita> getOne(@PathVariable("id") int id) {

        return citaService.getOne(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public Cita save(@RequestBody Cita cita) {

        return citaService.save(cita);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/editar/{id}")
    public Cita editar(@RequestBody Cita cita, @PathVariable("id") int id) {

        return citaService.editar(id, cita);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") int id) {

        citaService.delete(id);
    }

    // Solicitud para ingreso de 2 microservicios : Persona llama a todas las citas
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-my-citas/{idpaciente}")
    public ResponseEntity<?> findByIdCita(@PathVariable int idpaciente) {

        return ResponseEntity.ok(citaService.findByIdPaciente(idpaciente));

    }

    // Buscar Cita y a la persona que le corresponde
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-my-paciente-porIdCita/{idpac}")
    public ResponseEntity<?> findPacienteIdCita(@PathVariable("idpac") int idpac) {
        return ResponseEntity.ok(citaService.findPacienteByIdCita(idpac));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-todas-citas-con-pacientes")
    public ResponseEntity<?> findAllCitasWithPacientes() {
        return ResponseEntity.ok(citaService.findAllCitasWithPacientes());
    }

     @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-citas-por-fecha/{fecha}")
    public ResponseEntity<?> findCitasByFechaWithPacientes(
            @PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        List<PacienteByIdCita> citasConPacientes = citaService.findCitasByFechaWithPacientes(fecha);
        return ResponseEntity.ok(citasConPacientes);
    }

}
