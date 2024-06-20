package com.InfoClinicoAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InfoClinicoAPI.Entity.Sesiones;
import com.InfoClinicoAPI.Repositorio.SesionRepo;

@Service
public class SesionService {
    
    @Autowired
    private SesionRepo sesionRepo;

    public List<Sesiones> getAll(){

        return sesionRepo.findAll();
    }
    public Optional<Sesiones> getOne(int id){
        return sesionRepo.findById(id);
    }
    public Sesiones save(Sesiones sesion){
        return sesionRepo.save(sesion);
    }
        
    public Sesiones update(int id, Sesiones sesion){

    Sesiones upsesion = new Sesiones();

        upsesion.setFecha(sesion.getFecha());
        upsesion.setHora(sesion.getHora());
        upsesion.setTratamiento(sesion.getTratamiento());
        upsesion.setAsistencia(sesion.getAsistencia());
        return sesionRepo.save(upsesion);
    }

    
    public void delete(int id){

        sesionRepo.deleteById(id);
    }

}
