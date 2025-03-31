package com.ItRoid.turnera.services;

import org.springframework.web.multipart.MultipartFile;

public interface FotoService <T>{

    void subirFoto(MultipartFile foto) throws Exception;

    String verFoto(Long IdProfecional);


}
