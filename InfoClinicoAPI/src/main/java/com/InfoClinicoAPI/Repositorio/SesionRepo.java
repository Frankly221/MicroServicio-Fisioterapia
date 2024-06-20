package com.InfoClinicoAPI.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InfoClinicoAPI.Entity.Sesiones;

@Repository
public interface SesionRepo extends JpaRepository<Sesiones, Integer> {



    
}
