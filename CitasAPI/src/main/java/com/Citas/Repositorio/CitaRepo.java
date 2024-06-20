package com.Citas.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Citas.Entity.Cita;

@Repository

public interface  CitaRepo extends JpaRepository<Cita, Integer> {

   
    List<Cita> findByIdpaciente(int idpaciente);
    
}
