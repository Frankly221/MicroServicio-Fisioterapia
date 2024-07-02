package com.PacienteAPI.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CitaDTO {

    private String tipo;
    private int idpaciente;
    private Date hora;
    private int n_sesion;
    private Date fecha;
    
}
