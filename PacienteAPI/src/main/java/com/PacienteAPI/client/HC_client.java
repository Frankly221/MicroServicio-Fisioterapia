package com.PacienteAPI.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PacienteAPI.DTO.hcDTO;

@FeignClient(name = "InfoClinicoAPI", url = "localhost:8081/api/if")
public interface HC_client {

    @GetMapping("buscar-my-hc/{idpaciente}")
    List<hcDTO> findAllHcByid(@PathVariable("idpaciente") int idpaciente);
    
}
