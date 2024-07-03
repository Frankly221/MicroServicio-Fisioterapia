package com.Citas.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@Table(name = "estado_cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EstadoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado_cita;


    private String nombre_estado;


    @OneToMany(mappedBy = "estadoCita")
    @JsonIgnore
    private List<Cita> citas;

    
}
