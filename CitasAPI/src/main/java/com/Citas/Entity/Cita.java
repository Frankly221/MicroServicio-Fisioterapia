package com.Citas.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "citas")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcita;
    
    private String tipo;
    
    private int idpaciente;
    
    private Date hora;
    
    private Date fecha;
    
    // Campo para el número de sesión
    private int n_sesion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_cita") // Nombre de la columna en la tabla de Cita
    @JsonIgnoreProperties({"citas"}) // Ignorar la referencia inversa para evitar ciclos
    private EstadoCita estadoCita; // Relación con EstadoCita
    
    // Getters and setters
}
