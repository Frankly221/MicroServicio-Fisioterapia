package com.PagoAPI.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PagoAPI.DTO.PagoDTO;
import com.PagoAPI.Entity.Pago;
import com.PagoAPI.Mapper.PagoMapper;
import com.PagoAPI.Repositorio.PagoRepo;

@Service

public class PagoService {

    @Autowired
    private PagoRepo pagoRepository;
    public List<PagoDTO> getAll(){
        List<Pago> pago = pagoRepository.findAll();


        return pago.stream().map(PagoMapper::DatosToDTO).collect(Collectors.toList());
    }
//---------------------------------------------------------------------------------------------

    public List<PagoDTO> getAllWithoutIdHc(){
        List<Pago> pago = pagoRepository.findAll();

        return pago.stream().map(PagoMapper::DatosToDtowithoutIdHc).collect(Collectors.toList());
    }
//---------------------------------------------------------------------------------------------

    public Optional<PagoDTO> getOne(int id){


            Optional <Pago> pago = pagoRepository.findById(id); 
            
            
        return pago.map(PagoMapper::DatosToDTO);
    }

//---------------------------------------------------------------------------------------------

    
    public Optional<PagoDTO> getOneWhithoutIdHc(int id){


        Optional <Pago> pago = pagoRepository.findById(id); 
        
        
    return pago.map(PagoMapper::DatosToDtowithoutIdHc);
}
//---------------------------------------------------------------------------------------------



    public PagoDTO save(PagoDTO pagoDTO){

        Pago pago = PagoMapper.DatosToEntity(pagoDTO);
        Pago savePago = pagoRepository.save(pago);


        return PagoMapper.DatosToDTO(savePago);


    }




    public PagoDTO editar(int id, PagoDTO pagoDTO) {

        Pago Existepago = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago No Encontrado"));
    
        Existepago.setN_sesion(pagoDTO.getN_sesion());
        Existepago.setFecha(pagoDTO.getFecha());
        Existepago.setPago(pagoDTO.getPago());
    
        if (pagoDTO.getIdhc() != null) {
            if (pagoDTO.getIdhc() != 0) {
                Existepago.setIdhc(pagoDTO.getIdhc());
            } else {
                throw new RuntimeException("0 no es un número válido para idhc");
            }
        } else {
            throw new RuntimeException("idhc no válido");
        }
    
        pagoRepository.save(Existepago);
        return PagoMapper.DatosToDTO(Existepago);
    }
    






    public void delete(int id){

        pagoRepository.deleteById(id);
    }
        


    //conexion

    // public List<Pago> findByIdHc(int idhc){

    //     return pagoRepository.findByIdhc(idhc);
    // }

    public List<PagoDTO> FindPagosForIdHc(int idhc){
        List<Pago> pago = pagoRepository.findByIdhc(idhc);


        return pago.stream().map(PagoMapper::DatosToDTO).collect(Collectors.toList());
    }













    
}
