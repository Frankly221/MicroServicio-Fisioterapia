package com.PacienteAPI.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PacienteAPI.DTO.Client.CitaDTO;
import com.PacienteAPI.DTO.Client.hcDTO;
import com.PacienteAPI.DTO.Propio.PacienteDTO;
import com.PacienteAPI.Entity.Paciente;
import com.PacienteAPI.Mapper.PacienteMapper;
import com.PacienteAPI.Repositorio.PacienteRepo;
import com.PacienteAPI.client.Citas_client;
import com.PacienteAPI.client.HC_client;
import com.PacienteAPI.http.Response.PacienteDTOToCita;
import com.PacienteAPI.http.Response.PacienteDTOToHC;


@Service
public class  PacienteServi  {

    @Autowired
   private PacienteRepo pacienteRepo;

   @Autowired
   private HC_client hc_client;

   @Autowired
   private Citas_client citas_client;

   

    public List<PacienteDTO> getALL(){
        List<Paciente> pacientes = pacienteRepo.findAll();

        return pacientes.stream().map(PacienteMapper::DatosToDTO).collect(Collectors.toList());
    }



    public Optional<PacienteDTO> getOne(int id){
        //Captura la informacion persistiendo a la base de datos segun el id establecido.

        Optional<Paciente> paciente = pacienteRepo.findById(id);

        //hace la conversion de entity a DTO y lo retorna.
        return paciente.map(PacienteMapper::DatosToDTO);
    }

    


    public PacienteDTO save(PacienteDTO pacienteDTO){
        Paciente paciente = PacienteMapper.DatosToEntity(pacienteDTO);
        Paciente savePaciente = pacienteRepo.save(paciente);


        return PacienteMapper.DatosToDTO(savePaciente);
    }



    public PacienteDTO update(int id, PacienteDTO pacienteDTO) {

        Paciente Existepaciente = pacienteRepo.findById(id).orElseThrow(()-> new RuntimeException("Paciente not found with id: " + id)) ;

        Existepaciente.setNombre(pacienteDTO.getNombre());
        Existepaciente.setApellido(pacienteDTO.getApellido());
        Existepaciente.setDomicilio(pacienteDTO.getDomicilio());
        Existepaciente.setFecha_nac(pacienteDTO.getFecha_nac());
        Existepaciente.setLugar_nac(pacienteDTO.getLugar_nac());
        Existepaciente.setTelefono(pacienteDTO.getTelefono());
        Existepaciente.setResidencia(pacienteDTO.getResidencia());
        Existepaciente.setEstado_civil(pacienteDTO.getEstado_civil());
        Existepaciente.setN_hijos(pacienteDTO.getN_hijos());
        Existepaciente.setReferencia(pacienteDTO.getReferencia());
        Existepaciente.setNdoc_documento(pacienteDTO.getNdoc_documento());
        Existepaciente.setTipo_documento(pacienteDTO.getTipo_documento());
        Existepaciente.setCorreo(pacienteDTO.getCorreo());

        pacienteRepo.save(Existepaciente);

        return PacienteMapper.DatosToDTO(Existepaciente);

    }

    public void delete(int id){

        pacienteRepo.deleteById(id);
    }




    //Apartado para conexion entre microservicios

    public PacienteDTOToHC findHcByIdPaciente(int idpaciente){
       //consultar el paciente

       Paciente paciente = pacienteRepo.findById(idpaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        //Obtener los HC

        List<hcDTO> hcDTOsList =  hc_client.findAllHcByid(idpaciente);

         // Convertir Paciente a PacienteDTO usando el mapper
         PacienteDTO pacienteDTO = PacienteMapper.DatosToDTO(paciente);

       return  PacienteDTOToHC.builder()
       .Nombre(pacienteDTO.getNombre())
       .Apellido(pacienteDTO.getApellido())
       .Domicilio(pacienteDTO.getDomicilio())
       .FechaNac(pacienteDTO.getFecha_nac())
       .LugarNac(pacienteDTO.getLugar_nac())
       .Telefono(pacienteDTO.getTelefono())
       .Residencia(pacienteDTO.getResidencia())
       .EstadoCivil(pacienteDTO.getEstado_civil())
       .nHijos(pacienteDTO.getN_hijos())
       .Referencia(pacienteDTO.getReferencia())
       .ndoc_documento(pacienteDTO.getNdoc_documento())
       .tipo_documento(pacienteDTO.getTipo_documento())
       .correo(pacienteDTO.getCorreo())
       .hcDTOsList(hcDTOsList)
       .build(); 
    }
    
    public PacienteDTOToCita findCitasByIdPaciente(int idpaciente){
        
        //Consultar el paciente
        Paciente paciente = pacienteRepo.findById(idpaciente).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        //Obtener todas las citas
        List<CitaDTO> CitaDTOList = citas_client.findAllCitaById(idpaciente);

        // Convertir Paciente a PacienteDTO usando el mapper
        PacienteDTO pacienteDTO = PacienteMapper.DatosToDTO(paciente);
        

        
        return PacienteDTOToCita.builder()
        .Nombre(pacienteDTO.getNombre())
       .Apellido(pacienteDTO.getApellido())
       .Domicilio(pacienteDTO.getDomicilio())
       .FechaNac(pacienteDTO.getFecha_nac())
       .LugarNac(pacienteDTO.getLugar_nac())
       .Telefono(pacienteDTO.getTelefono())
       .Residencia(pacienteDTO.getResidencia())
       .EstadoCivil(pacienteDTO.getEstado_civil())
       .nHijos(pacienteDTO.getN_hijos())
       .Referencia(pacienteDTO.getReferencia())
       .ndoc_documento(pacienteDTO.getNdoc_documento())
       .tipo_documento(pacienteDTO.getTipo_documento())
       .correo(pacienteDTO.getCorreo())
       
        .citaDTIOList(CitaDTOList)
        .build();
       
        

    }


    public Optional<PacienteDTO> findByIdPac(int idpac){

        Optional<Paciente> paciente = pacienteRepo.findByIdpac(idpac);


        return paciente.map(PacienteMapper::DatosToDTO);
    }




}
