package com.PagoAPI.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pago")
@Entity

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpago;

    private int n_sesion;
    private Double pago;
    private Date fecha;
    private int idhc;
    
}
