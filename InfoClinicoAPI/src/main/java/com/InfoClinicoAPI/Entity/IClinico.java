package com.InfoClinicoAPI.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "info_clinico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhc;

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
    
}
