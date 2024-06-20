package com.InfoClinicoAPI.Http;

import java.util.Date;
import java.util.List;

import com.InfoClinicoAPI.DTO.PagoDTO;
import com.InfoClinicoAPI.Entity.Sesiones;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PagoByHcResponse {

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

     @OneToMany(mappedBy = "infoClinico")
     @JsonManagedReference
    private List<Sesiones> sesiones;

    private List<PagoDTO> pagoDTOList;

    
}
