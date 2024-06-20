package com.InfoClinicoAPI.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InfoClinicoAPI.Entity.IClinico;

@Repository

public interface  IFRepo  extends  JpaRepository<IClinico, Integer>{
    List<IClinico> findByIdpaciente(int idpaciente);
    
}
