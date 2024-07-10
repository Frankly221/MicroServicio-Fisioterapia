package com.PacienteAPI.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PacienteAPI.DTO.Client.CitaDTO;

@FeignClient(name = "CitasAPI", url = "localhost:7272/api/cita")


public interface  Citas_client {


    @GetMapping("buscar-my-citas/{idpaciente}")
    List<CitaDTO> findAllCitaById(@PathVariable("idpaciente") int idpaciente);

    
}
