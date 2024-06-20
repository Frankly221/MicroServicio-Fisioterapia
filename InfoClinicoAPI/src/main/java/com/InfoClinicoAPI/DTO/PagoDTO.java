package com.InfoClinicoAPI.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor

public class PagoDTO {
    
    private int n_sesion;
    private Double pago;
    private Date fecha;
}
