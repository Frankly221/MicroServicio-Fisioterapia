package com.InfoClinicoAPI.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Entity
@Builder
@Data
@Table(name ="sesiones")
@AllArgsConstructor
@NoArgsConstructor


public class Sesiones {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int  id_nsesiones;
   
   private Date fecha;
   
   private String hora;
   
   private String tratamiento;
   
   private String asistencia;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name ="idhc")
   @JsonBackReference
   private IClinico infoClinico;
}
