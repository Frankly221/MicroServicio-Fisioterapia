package com.InfoClinicoAPI.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InfoClinicoAPI.DTO.PagoDTO;
import com.InfoClinicoAPI.Entity.IClinico;
import com.InfoClinicoAPI.Http.PagoByHcResponse;
import com.InfoClinicoAPI.Repositorio.IFRepo;
import com.InfoClinicoAPI.client.Pago_Client;

@Service

public class IFService {

   @Autowired
   private IFRepo ifRepo;

   @Autowired
   private Pago_Client pago_Client;

    public List<IClinico> getAll(){

        return ifRepo.findAll();
    }

    public List<IClinico> findByIdPaciente(int idpaciente) {
        return ifRepo.findByIdpaciente(idpaciente);
    }

    public Optional<IClinico> getOne(int id){
        return ifRepo.findById(id);
    }

    public IClinico save(IClinico iClinico){
        return ifRepo.save(iClinico);
    }

    public IClinico update(int id, IClinico iClinico){

        Optional<IClinico> existingIclinico = ifRepo.findById(id);

        if(existingIclinico.isPresent()){
            IClinico icl = existingIclinico.get();
            icl.setInic_enferm(iClinico.getInic_enferm());
            icl.setEtiologia(iClinico.getEtiologia());
            icl.setDiagnostico(iClinico.getDiagnostico());
            icl.setObservacion(iClinico.getObservacion());
            icl.setFech_eval(iClinico.getFech_eval());
            icl.setInic_trat(iClinico.getInic_trat());
            icl.setPeso(iClinico.getPeso());
            icl.setTalla(iClinico.getPeso());
            icl.setTemp(iClinico.getTemp());
            icl.setGs(iClinico.getGs());
            icl.setFc(iClinico.getFc());
            icl.setEnf_cronic(iClinico.getEnf_cronic());

            return ifRepo.save(icl);
        }
        else{
            throw new IllegalArgumentException("Informacion Clinico not found with id: " + id);
        }
    }


    public void delete(int id){

        ifRepo.deleteById(id);
    }
    



    //Conexiones
    public PagoByHcResponse   findPagosByIdHc(int idhc){


        //Consultar que hc a consultar
        IClinico icl = ifRepo.findById(idhc).orElse(new IClinico());

        //Dar los pagos asociados al Historial Clinico

        List<PagoDTO> pagoDTOList = pago_Client.findAllPagoById(idhc);


        return PagoByHcResponse.builder()
        .inic_enferm(icl.getInic_enferm())
        .etiologia(icl.getEtiologia())
        .diagnostico(icl.getDiagnostico())
        .observacion(icl.getObservacion())
        .fech_eval(icl.getFech_eval())
        .inic_trat(icl.getInic_trat())
        .peso(icl.getPeso())
        .talla(icl.getTalla())
        .temp(icl.getTemp())
        .gs(icl.getGs())
        .fc(icl.getFc())
        .enf_cronic(icl.getEnf_cronic())
        .idpaciente(icl.getIdpaciente())
        .sesiones(icl.getSesiones())
        .pagoDTOList(pagoDTOList)
        
        .build();
    }

    
}
