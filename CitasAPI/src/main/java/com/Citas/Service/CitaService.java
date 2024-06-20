package com.Citas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Citas.Entity.Cita;
import com.Citas.Repositorio.CitaRepo;

@Service

public class CitaService {

    @Autowired
    private CitaRepo citaRepo;

    public List<Cita> getAll(){
        return citaRepo.findAll();
    }

    public Optional<Cita> getOne(int id){

        return citaRepo.findById(id);
    }

    public Cita save(Cita cita){

        return citaRepo.save(cita);


    }

    public Cita editar(int id, Cita cita){

        Cita citaUP = new Cita();

        citaUP.setTipo(cita.getTipo());
        citaUP.setHora(cita.getHora());
        citaUP.setN_sesion(cita.getN_sesion());

        return citaRepo.save(citaUP);

    }

    public void delete(int id){
        citaRepo.deleteById(id);
    }



    //Conexion entre 2 microservicios busqueda de todo las citas de un paciente

    public List<Cita> findByIdPaciente(int idpaciente){

        return citaRepo.findByIdpaciente(idpaciente);
    }

    
}
