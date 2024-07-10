package com.PacienteAPI.http.Response;

import java.util.Date;
import java.util.List;

import com.PacienteAPI.DTO.Client.hcDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDTOToHC {

    private String Nombre;
    private String Apellido;
    
    private String Domicilio;

    private Date FechaNac;

    private  String LugarNac;


    private int Telefono;

    private String Residencia;

    private String EstadoCivil;

    private int  nHijos;

    private String Referencia;

    private Boolean tipo_documento;
    private int  ndoc_documento;
    private String correo;
    

    private List<hcDTO> hcDTOsList;
    
}
