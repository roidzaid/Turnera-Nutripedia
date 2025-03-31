package com.ItRoid.turnera.controllers;

import com.ItRoid.turnera.services.FotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("fotos")
public class FotoController {

    Logger logger = LoggerFactory.getLogger(FotoController.class);

    @Autowired
    private FotoService fotoService;


    @PostMapping()
    public ResponseEntity<?> guardarFoto(@RequestParam(value = "fileMultipart", required = true) MultipartFile multipartFile) throws Exception  {

        logger.info("Se guardar foto de perfil para el profesional");

        try {

            this.fotoService.subirFoto(multipartFile);

            logger.info("Se guardo la foto correctamente");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){

            logger.info("Error al guardar la foto " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{idProfesional}")
    public ResponseEntity<?> cargarFoto(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se busca foto");

        try {

            String foto = this.fotoService.verFoto(idProfesional);

            return new ResponseEntity<String>(foto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
