package com.Citas.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Citas.Entity.EstadoCita;

@Repository

public interface EstadoCitaRepo extends  JpaRepository<EstadoCita, Integer> {
    
}
