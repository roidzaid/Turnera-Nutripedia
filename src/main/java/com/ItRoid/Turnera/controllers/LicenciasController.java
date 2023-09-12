package com.ItRoid.Turnera.controllers;


import com.ItRoid.Turnera.entities.LicenciasEntity;
import com.ItRoid.Turnera.models.LicenciasModel;
import com.ItRoid.Turnera.services.LicenciasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("licencias")
public class LicenciasController {

    Logger logger = LoggerFactory.getLogger(LicenciasController.class);

    @Autowired
    private LicenciasService licenciasService;


    @PostMapping()
    public ResponseEntity<?> altaLicencia(@RequestBody LicenciasModel licenciasModel) throws Exception  {

        logger.info("Se da de alta las licencias para:" + licenciasModel.getIdProfesional());

        try {

            LicenciasModel l = this.licenciasService.altaLicencia(licenciasModel);

            return new ResponseEntity<LicenciasModel>(l, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lista/{idProfesional}")
    public ResponseEntity<?> listarLicencias(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se listan las licencias de: " + idProfesional);

        try {

            List<LicenciasEntity> licencias = this.licenciasService.buscarLicencias(idProfesional);

            return new ResponseEntity<List<LicenciasEntity>>(licencias, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idProfesional}/{idLicencia}")
    public ResponseEntity<?> buscarLicencia(@PathVariable("idProfesional") Long idProfesional, @PathVariable("idLicencia") Long idLicencia) throws Exception{

        logger.info("Se busca la licencia: " + idLicencia);

        try {

            LicenciasModel licencia = this.licenciasService.buscarLicencia(idProfesional, idLicencia);

            return new ResponseEntity<LicenciasModel>(licencia, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idProfesional}/{idLicencia}")
    public ResponseEntity<?> modificarLicencias(@PathVariable("idProfesional") Long idProfesional, @PathVariable("idLicencia") Long idLicencia, @RequestBody LicenciasModel licenciasModel) throws Exception  {

        logger.info("Se modifica licencias para el profesional: " + licenciasModel.getIdProfesional());

        try {
            LicenciasModel l = this.licenciasService.modifLicencia(idProfesional, idLicencia, licenciasModel);

            return new ResponseEntity<LicenciasModel>(l, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{idProfesional}/{idLicencia}")
    public ResponseEntity<?> eliminarLicencias(@PathVariable("idProfesional") Long idProfesional, @PathVariable("idLicencia") Long idLicencia) throws Exception  {

        logger.info("Se elimina licencias del profesional: " + idProfesional);

        try {
            this.licenciasService.deleteLicencia(idProfesional, idLicencia);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
