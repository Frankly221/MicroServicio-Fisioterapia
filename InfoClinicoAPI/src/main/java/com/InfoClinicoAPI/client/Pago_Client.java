package com.InfoClinicoAPI.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.InfoClinicoAPI.DTO.PagoDTO;

// @FeignClient(name = "PagoAPI", url = "localhost:8082/api/pago")
@FeignClient(name = "PagoAPI", url = "http://localhost:8082/api/pago")


public interface  Pago_Client {



    @GetMapping("buscar-my-pago/{idhc}")
    List<PagoDTO> findAllPagoById(@PathVariable("idhc") int idhc);
    
}
