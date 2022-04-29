package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.services.FotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FotoServiceImpl implements FotoService {

    @Value("${path.fotos}")
    private String path;



    @Override
    public void subirFoto(MultipartFile foto) throws Exception {

        Path pathAbsolute = Paths.get(path);

        String nombreFoto = foto.getOriginalFilename();

        File fotoVieja = new File(pathAbsolute+"/"+nombreFoto);

        fotoVieja.delete();

        Files.copy(foto.getInputStream(), pathAbsolute.resolve(nombreFoto));

    }

    @Override
    public String verFoto(Long IdProfecional) {

        return IdProfecional.toString()+".jpg";

    }
}
