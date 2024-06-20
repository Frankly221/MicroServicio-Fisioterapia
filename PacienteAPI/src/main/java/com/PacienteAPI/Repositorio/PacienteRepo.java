package com.PacienteAPI.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PacienteAPI.Entity.Paciente;


public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
    
}
