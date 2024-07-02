package com.Citas.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PacienteDTO {

    private int idpac;
    
    private String nombre;

    private String apellido;

    private String domicilio;

    private Date fecha_nac;

    private  String lugar_nac;

    private int telefono;

    private String residencia;

    private String estado_civil;

    private int n_hijos;

    private String referencia;

    //Agregados

    private Boolean tipo_documento;
    private int ndoc_documento;
    private String correo;
    
}
