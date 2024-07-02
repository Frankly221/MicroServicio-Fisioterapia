package com.Citas.Http.Response;



import java.util.Date;
import java.util.Optional;

import com.Citas.DTO.PacienteDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PacienteByIdCita {


     private int idcita;
    
    private String tipo;
    
    private int idpaciente;
    
    private Date hora;
    
    private Date fecha;
    
    // Campo para el número de sesión
    private int n_sesion;

    private Optional<PacienteDTO> pacienteDTOs;
    
}
