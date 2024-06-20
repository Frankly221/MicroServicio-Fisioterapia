package com.InfoClinicoAPI.Controller;

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

import com.InfoClinicoAPI.Entity.Sesiones;
import com.InfoClinicoAPI.Service.SesionService;

@RestController
@RequestMapping(value = "/api/sesion")
@CrossOrigin("/**")
public class SesionController {

    @Autowired
    private SesionService sesionService;
    @ResponseStatus(HttpStatus.OK)
    public List<Sesiones> getAll(){
        return sesionService.getAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<Sesiones> getOne(@PathVariable("id") int id){
        return sesionService.getOne(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public Sesiones save(@RequestBody Sesiones sesiones){
        return sesionService.save(sesiones);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/save")
    public Sesiones editar(@RequestBody Sesiones sesiones, @PathVariable("id") int id){

        return sesionService.update(id,sesiones);
    }




    
}
