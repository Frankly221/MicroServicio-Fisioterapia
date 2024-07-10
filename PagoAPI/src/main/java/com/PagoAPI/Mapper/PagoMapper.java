package com.PagoAPI.Mapper;

import com.PagoAPI.DTO.PagoDTO;
import com.PagoAPI.Entity.Pago;

public class PagoMapper {

    public static PagoDTO DatosToDTO(Pago pago){

        
        PagoDTO pagodto = new PagoDTO();

        pagodto.setIdpago(pago.getIdpago());
        pagodto.setFecha(pago.getFecha());
        pagodto.setN_sesion(pago.getN_sesion());
        pagodto.setPago(pago.getPago());
        pagodto.setIdhc(pago.getIdhc());
        return pagodto;	


    }

    public static PagoDTO DatosToDtowithoutIdHc(Pago pago){
        PagoDTO pagodto = new PagoDTO();

        pagodto.setIdpago(pago.getIdpago());
        pagodto.setFecha(pago.getFecha());
        pagodto.setN_sesion(pago.getN_sesion());
        pagodto.setPago(pago.getPago());
        return pagodto;	

    }

  //  ------------------------------------------------------

    public static Pago DatosToEntity(PagoDTO pagoDTO){

        Pago pago = new Pago();
        pago.setFecha(pagoDTO.getFecha());
        pago.setN_sesion(pagoDTO.getN_sesion());
        pago.setPago(pagoDTO.getPago());
        pago.setIdhc(pagoDTO.getIdhc());

        return pago;

    }










    
}
