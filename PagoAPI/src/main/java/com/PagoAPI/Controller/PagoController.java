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

import com.PagoAPI.DTO.PagoDTO;
import com.PagoAPI.Service.PagoService;

@RestController
@RequestMapping(value = "/api/pago")
@CrossOrigin("/**")

public class PagoController {

    @Autowired
    private PagoService pagoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<PagoDTO> getAll(){

        return pagoService.getAll();
    }
//----------------------------------------------------------------
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allsinhc")
    public List<PagoDTO> getAllSinIdHc(){

        return pagoService.getAllWithoutIdHc();
    }
//----------------------------------------------------------------
@ResponseStatus(HttpStatus.OK)
@GetMapping("/one/sinhc/{id}")
public Optional<PagoDTO> getOneSinHc(@PathVariable("id") int id){

    return pagoService.getOneWhithoutIdHc(id);
}

//----------------------------------------------------------------





    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/one/{id}")
    public Optional<PagoDTO> getOne(@PathVariable("id") int id){

        return pagoService.getOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public PagoDTO save(@RequestBody PagoDTO pagoDTO){

        return pagoService.save(pagoDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/edit/{id}")
    public PagoDTO editar(@RequestBody PagoDTO pago, @PathVariable("id") int id){

        return pagoService.editar(id, pago);
    }



        //Conexiones

        //Recuperamos el id del Historial Clinica y respondemos todos los pagos que le pertenece a este.
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar-my-pago/{idhc}")
    public ResponseEntity<?> findByIdHc(@PathVariable int idhc){

        return ResponseEntity.ok(pagoService.FindPagosForIdHc(idhc));
    }












    
}
