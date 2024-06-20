package com.PagoAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PagoAPI.Entity.Pago;
import com.PagoAPI.Repositorio.PagoRepo;

@Service

public class PagoService {

    @Autowired
    private PagoRepo pagoRepository;

    public List<Pago> getAll(){
        return pagoRepository.findAll();
    }

    public Optional<Pago> getOne(int id){
        return pagoRepository.findById(id);
    }

    public Pago save(Pago pago){
        return pagoRepository.save(pago);
    }

    public Pago editar(int id, Pago pago){

        Pago upPago = new Pago();
        upPago.setN_sesion(pago.getN_sesion());
        upPago.setFecha(pago.getFecha());
        upPago.setPago(pago.getPago());




        return pagoRepository.save(upPago);
    }

    public void delete(int id){

        pagoRepository.deleteById(id);
    }
        


    //conexion

    public List<Pago> findByIdHc(int idhc){

        return pagoRepository.findByIdhc(idhc);
    }













    
}
