package com.PagoAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.PagoAPI.Entity.Pago;
import com.PagoAPI.Service.PagoService;

@RestController
@RequestMapping(value = "/api/pago")
@CrossOrigin("/**")

public class PagoController {

    @Autowired
    private PagoService pagoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Pago> getAll(){

        return pagoService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<Pago> getOne(@PathVariable("id") int id){

        return pagoService.getOne(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/save")
    public Pago save(@RequestBody Pago pago){

        return pagoService.save(pago);
    }


    @PutMapping("/edit/{id}")
    public Pago editar(@RequestBody Pago pago, @PathVariable("id") int id){

        return pagoService.editar(id, pago);
    }



        //Conexiones

    @GetMapping("/buscar-my-pago/{idhc}")
    public ResponseEntity<?> findByIdHc(@PathVariable int idhc){

        return ResponseEntity.ok(pagoService.findByIdHc(idhc));
    }












    
}
