package com.PacienteAPI.Mapper;

import com.PacienteAPI.DTO.Propio.PacienteDTO;
import com.PacienteAPI.Entity.Paciente;

public class PacienteMapper {

    public static PacienteDTO DatosToDTO(Paciente paciente){

        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setIdpac(paciente.getIdpac());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setDomicilio(paciente.getDomicilio());
        pacienteDTO.setFecha_nac(paciente.getFecha_nac());
        pacienteDTO.setLugar_nac(paciente.getLugar_nac());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setResidencia(paciente.getResidencia());
        pacienteDTO.setEstado_civil(paciente.getEstado_civil());
        pacienteDTO.setN_hijos(paciente.getN_hijos());
        pacienteDTO.setReferencia(paciente.getReferencia());
        pacienteDTO.setNdoc_documento(paciente.getNdoc_documento());
        pacienteDTO.setTipo_documento(paciente.getTipo_documento());
        pacienteDTO.setCorreo(paciente.getCorreo());
        return pacienteDTO;    
    }

    public static Paciente DatosToEntity(PacienteDTO pacienteDTO){

        Paciente paciente = new Paciente();

        paciente.setIdpac(pacienteDTO.getIdpac());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setDomicilio(pacienteDTO.getDomicilio());
        paciente.setFecha_nac(pacienteDTO.getFecha_nac());
        paciente.setLugar_nac(pacienteDTO.getLugar_nac());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setResidencia(pacienteDTO.getResidencia());
        paciente.setEstado_civil(pacienteDTO.getEstado_civil());
        paciente.setN_hijos(pacienteDTO.getN_hijos());
        paciente.setReferencia(pacienteDTO.getReferencia());
        paciente.setNdoc_documento(pacienteDTO.getNdoc_documento());
        paciente.setTipo_documento(pacienteDTO.getTipo_documento());
        paciente.setCorreo(pacienteDTO.getCorreo());
        return paciente;    
    }


    
}
