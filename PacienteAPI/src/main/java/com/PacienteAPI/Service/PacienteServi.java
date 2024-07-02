package com.PacienteAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PacienteAPI.DTO.CitaDTO;
import com.PacienteAPI.DTO.hcDTO;
import com.PacienteAPI.Entity.Paciente;
import com.PacienteAPI.Repositorio.PacienteRepo;
import com.PacienteAPI.client.Citas_client;
import com.PacienteAPI.client.HC_client;
import com.PacienteAPI.http.Response.CitasByPacienteResponse;
import com.PacienteAPI.http.Response.HcByPacienteResponse;


@Service
public class  PacienteServi  {

    @Autowired
   private PacienteRepo pacienteRepo;

   @Autowired
   private HC_client hc_client;

   @Autowired
   private Citas_client citas_client;

   

    public List<Paciente> getALL(){

        return pacienteRepo.findAll();
    }

    public Optional<Paciente> getOne(int id){

        return pacienteRepo.findById(id);
    }

    public Paciente save(Paciente paciente){

        return pacienteRepo.save(paciente);
    }

    public Paciente update(int id, Paciente paciente) {
        Optional<Paciente> existingPaciente = pacienteRepo.findById(id);
        if (existingPaciente.isPresent()) {
            Paciente p = existingPaciente.get();
            p.setNombre(paciente.getNombre());
            p.setApellido(paciente.getApellido());
            p.setDomicilio(paciente.getDomicilio());
            p.setFecha_nac(paciente.getFecha_nac());
            p.setLugar_nac(paciente.getLugar_nac());
            p.setTelefono(paciente.getTelefono());
            p.setResidencia(paciente.getResidencia());
            p.setEstado_civil(paciente.getEstado_civil());
            p.setN_hijos(paciente.getN_hijos()); // Asegúrate de actualizar nHijos correctamente
            p.setReferencia(paciente.getReferencia());
            p.setNdoc_documento(paciente.getNdoc_documento());
            p.setTipo_documento(paciente.getTipo_documento());
            p.setCorreo(paciente.getCorreo());
            return pacienteRepo.save(p);
        } else {
            throw new IllegalArgumentException("Paciente not found with id: " + id);
        }
    }

    public void delete(int id){

        pacienteRepo.deleteById(id);
    }




    //Apartado para conexion entre microservicios

    public HcByPacienteResponse findHcByIdPaciente(int idpaciente){
       //consultar el paciente
       Paciente paciente = pacienteRepo.findById(idpaciente).orElse(new Paciente());
        //Obtener los HC
        List<hcDTO> hcDTOsList =  hc_client.findAllHcByid(idpaciente);

       return  HcByPacienteResponse.builder()
       .PacienteNombre(paciente.getNombre())
       .PacienteApellido(paciente.getApellido())
       .PacienteDomicilio(paciente.getDomicilio())
       .PacienteFechaNac(paciente.getFecha_nac())
       .PacienteLugarNac(paciente.getLugar_nac())
       .PacienteTelefono(paciente.getTelefono())
       .PacienteResidencia(paciente.getResidencia())
       .PacienteEstadoCivil(paciente.getEstado_civil())
       .PacientenHijos(paciente.getN_hijos())
       .PacienteReferencia(paciente.getReferencia())
       .Pacientendoc_documento(paciente.getNdoc_documento())
       .Pacientetipo_documento(paciente.getTipo_documento())
       .Pacientecorreo(paciente.getCorreo())
       .hcDTOsList(hcDTOsList)
       .build(); 
    }
    
    public CitasByPacienteResponse findCitasByIdPaciente(int idpaciente){

        //Consultar el paciente
        Paciente paciente = pacienteRepo.findById(idpaciente).orElse(new Paciente());
        //Obtener todas las citas
        List<CitaDTO> CitaDTOList = citas_client.findAllCitaById(idpaciente);

        return CitasByPacienteResponse.builder()
        .PacienteNombre(paciente.getNombre())
       .PacienteApellido(paciente.getApellido())
       .PacienteDomicilio(paciente.getDomicilio())
       .PacienteFechaNac(paciente.getFecha_nac())
       .PacienteLugarNac(paciente.getLugar_nac())
       .PacienteTelefono(paciente.getTelefono())
       .PacienteResidencia(paciente.getResidencia())
       .PacienteEstadoCivil(paciente.getEstado_civil())
       .PacientenHijos(paciente.getN_hijos())
       .PacienteReferencia(paciente.getReferencia())
       .Pacientendoc_documento(paciente.getNdoc_documento())
       .Pacientetipo_documento(paciente.getTipo_documento())
       .Pacientecorreo(paciente.getCorreo())
       
        .citaDTIOList(CitaDTOList)
        .build();
       
        

    }


}
