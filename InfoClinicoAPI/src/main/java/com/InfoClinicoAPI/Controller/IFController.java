package com.InfoClinicoAPI.Controller;

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

import com.InfoClinicoAPI.Entity.IClinico;
import com.InfoClinicoAPI.Service.IFService;

@RestController
@RequestMapping(value = "/api/if")
@CrossOrigin("/**")

public class IFController {

    @Autowired
    private IFService ifService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<IClinico> getAll() {

        return ifService.getAll();
    }

    @GetMapping("/one/{id}")
    public Optional<IClinico> getOne(@PathVariable("id")int id){

        return ifService.getOne(id);
    }

    @PostMapping("/save")
    public IClinico save(@RequestBody IClinico iclinico){

        return ifService.save(iclinico);
    }

    @PutMapping("/edit/{id}")
    public IClinico edit(@PathVariable("id")int id, @RequestBody IClinico iclinico){

        return ifService.update(id, iclinico);
    }

    @GetMapping("buscar-my-hc/{idpaciente}")
    public ResponseEntity<?> findByIdHc(@PathVariable int idpaciente){
        return ResponseEntity.ok(ifService.findByIdPaciente(idpaciente));

    }

    ///Conexiones

    @GetMapping("/buscar-pago/{idhc}")
    public ResponseEntity<?> findPagoByIdHc(@PathVariable int idhc){
        
        return ResponseEntity.ok(ifService.findPagosByIdHc(idhc)); 
    }






}
