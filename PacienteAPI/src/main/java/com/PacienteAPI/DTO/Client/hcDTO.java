package com.PacienteAPI.DTO.Client;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class hcDTO {

    private String inic_enferm;
    private String etiologia;
    private String diagnostico;
    private String observacion;
    private Date fech_eval;
    private Date inic_trat;
    private Double peso;
    private Double talla;
    private Double temp;
    private String gs;
    private String fc;
    private String  enf_cronic;

    private int idpaciente;
    
}
