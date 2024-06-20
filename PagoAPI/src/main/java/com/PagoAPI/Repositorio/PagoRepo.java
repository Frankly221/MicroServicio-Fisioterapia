package com.PagoAPI.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PagoAPI.Entity.Pago;


@Repository
public interface PagoRepo extends JpaRepository<Pago , Integer> {

    List<Pago> findByIdhc(int idhc);
    
}
