package com.Citas.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Citas.Client.Paciente_Client;
import com.Citas.DTO.PacienteDTO;
import com.Citas.Entity.Cita;
import com.Citas.Http.Response.PacienteByIdCita;
import com.Citas.Repositorio.CitaRepo;

@Service

public class CitaService {

    @Autowired
    private CitaRepo citaRepo;

    @Autowired
    private Paciente_Client paciente_Client;

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


    //Traer citas
    public PacienteByIdCita findPacienteByIdCita(int idpac){

        //Llamamos los datos de Cita
        Cita cita = citaRepo.findById(idpac).orElse(new Cita());

        //Llamamos Los datos de Persona
         Optional<PacienteDTO> pacienteDTO = paciente_Client.findByIdPaciente(idpac);



        return PacienteByIdCita.builder()
        .idcita(cita.getIdcita())
        .tipo(cita.getTipo())
        .idpaciente(cita.getIdpaciente())
        .hora(cita.getHora())
        .fecha(cita.getFecha())
        .n_sesion(cita.getN_sesion())
        .pacienteDTOs(pacienteDTO)
        .build();





    }



    public List<PacienteByIdCita> findAllCitasWithPacientes() {
    // Llamamos todos los datos de Cita
    List<Cita> citas = citaRepo.findAll();
    
    // Creamos una lista para almacenar los resultados
    List<PacienteByIdCita> result = new ArrayList<>();
    
    // Iteramos sobre cada cita para obtener el paciente correspondiente
    for (Cita cita : citas) {
        // Llamamos los datos del Paciente
        Optional<PacienteDTO> pacienteDTO = paciente_Client.findByIdPaciente(cita.getIdpaciente());
        
        // Construimos el objeto PacienteByIdCita y lo añadimos a la lista de resultados
        PacienteByIdCita pacienteByIdCita = PacienteByIdCita.builder()
            .idcita(cita.getIdcita())
            .tipo(cita.getTipo())
            .idpaciente(cita.getIdpaciente())
            .hora(cita.getHora())
            .fecha(cita.getFecha())
            .n_sesion(cita.getN_sesion())
            .pacienteDTOs(pacienteDTO)
            .build();
        
        result.add(pacienteByIdCita);
    }
    
    return result;
}

public List<PacienteByIdCita> findCitasByFechaWithPacientes(Date fecha) {
    List<Cita> citas = citaRepo.findByFecha(fecha);
    List<PacienteByIdCita> result = new ArrayList<>();

    for (Cita cita : citas) {
        Optional<PacienteDTO> pacienteDTO = paciente_Client.findByIdPaciente(cita.getIdpaciente());

        PacienteByIdCita pacienteByIdCita = PacienteByIdCita.builder()
            .idcita(cita.getIdcita())
            .tipo(cita.getTipo())
            .idpaciente(cita.getIdpaciente())
            .hora(cita.getHora())
            .fecha(cita.getFecha())
            .n_sesion(cita.getN_sesion())
            .pacienteDTOs(pacienteDTO)
            .build();

        result.add(pacienteByIdCita);
    }

    return result;
}










    
}
