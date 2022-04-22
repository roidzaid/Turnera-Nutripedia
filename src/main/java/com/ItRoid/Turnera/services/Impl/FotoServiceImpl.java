package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.services.FotoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FotoServiceImpl implements FotoService {

    private final Path rootFolder = Paths.get("/imagenes");

    Path pathAbsolute = Paths.get("/Proyectos/TurneraFront/imagenes");
    Path pathBase = Paths.get("/Proyectos/TurneraFront");
    Path pathRelative = pathBase.relativize(pathAbsolute);


    @Override
    public void subirFoto(MultipartFile foto) throws Exception {

        String nombreFoto = foto.getOriginalFilename();

        File fotoVieja = new File(pathAbsolute+"/"+nombreFoto);

        fotoVieja.delete();

        Files.copy(foto.getInputStream(), this.pathAbsolute.resolve(nombreFoto));

    }

    @Override
    public String verFoto(Long IdProfecional) {

        return IdProfecional.toString()+".jpg";

    }
}
