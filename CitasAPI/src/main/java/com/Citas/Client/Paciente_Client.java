package com.Citas.Client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Citas.DTO.PacienteDTO;

@FeignClient(name = "PacienteAPI", url = "localhost:7171/api/paciente")
public interface Paciente_Client {

    @GetMapping("/buscar-paciente-por-id-cita/{idpac}")
    Optional<PacienteDTO> findByIdPaciente(@PathVariable("idpac") int idpac);
}
