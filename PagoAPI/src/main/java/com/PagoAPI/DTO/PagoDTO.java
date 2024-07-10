package com.PagoAPI.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PagoDTO {

    private int idpago;
    private int n_sesion;
    private Double pago;
    private Date fecha;
    private Integer idhc;
    
}
