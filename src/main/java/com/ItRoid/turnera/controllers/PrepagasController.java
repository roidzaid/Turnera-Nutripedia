package com.ItRoid.turnera.controllers;


import com.ItRoid.turnera.models.PrepagaModels;
import com.ItRoid.turnera.services.PrepagaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("prepagas")
public class PrepagasController {

    Logger logger = LoggerFactory.getLogger(PrepagasController.class);

    @Autowired
    private PrepagaService prepagaService;


    @PostMapping()
    public ResponseEntity<?> altaOs(@RequestBody PrepagaModels prepagaModels) throws Exception  {

        logger.info("Se da de alta la obra social " + prepagaModels.getPrepaga() + " para el profesional " + prepagaModels.getIdProfesional());

        try {

            this.prepagaService.altaPrepaga(prepagaModels);

            return new ResponseEntity<PrepagaModels>(prepagaModels, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{idProfesional}")
    public ResponseEntity<?> listarPrepagas(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se listan las prepagas de: " + idProfesional);

        try {

            List<PrepagaModels> prepagas = this.prepagaService.buscarPrepaga(idProfesional);

            return new ResponseEntity<List<PrepagaModels>>(prepagas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{idPrepagas}")
    public ResponseEntity<?> eliminarPrepaga(@PathVariable("idPrepagas") Long idPrepagas) throws Exception  {

        logger.info("Se elimina prepaga: " + idPrepagas);

        try {
            this.prepagaService.bajaPrepaga(idPrepagas);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("id/{idPrepaga}")
    public ResponseEntity<?> BuscaPrepaga(@PathVariable("idPrepaga") Long idPrepaga) throws Exception{

        logger.info("Se busca la relacion de propaga y profesional: " + idPrepaga);

        try {

            PrepagaModels prepaga = this.prepagaService.buscarPrepagaXId(idPrepaga);

            return new ResponseEntity<PrepagaModels>(prepaga, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
