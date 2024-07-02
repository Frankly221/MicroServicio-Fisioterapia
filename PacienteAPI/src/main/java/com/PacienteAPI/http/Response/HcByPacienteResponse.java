package com.PacienteAPI.http.Response;

import java.util.Date;
import java.util.List;

import com.PacienteAPI.DTO.hcDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HcByPacienteResponse {

    private String PacienteNombre;
    private String PacienteApellido;
    
    private String PacienteDomicilio;

    private Date PacienteFechaNac;

    private  String PacienteLugarNac;


    private int PacienteTelefono;

    private String PacienteResidencia;

    private String PacienteEstadoCivil;

    private int PacientenHijos;

    private String PacienteReferencia;

    private Boolean Pacientetipo_documento;
    private int Pacientendoc_documento;
    private String Pacientecorreo;
    

    private List<hcDTO> hcDTOsList;
    
}
