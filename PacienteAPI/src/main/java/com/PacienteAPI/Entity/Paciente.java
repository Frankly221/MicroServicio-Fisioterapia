package com.PacienteAPI.Entity;

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

@Table(name = "PacienteAPI")
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpac;

    private String nombre;

    private String apellido;

    private String domicilio;

    private Date fecha_nac;

    private  String lugar_nac;

    private int dni;

    private int telefono;

    private String residencia;

    private String estado_civil;

    private int n_hijos;

    private String referencia;
    
}
