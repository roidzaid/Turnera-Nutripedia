package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.services.ProfesionalesService;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("profesionales")
public class ProfesionalesController {

    Logger logger = LoggerFactory.getLogger(ProfesionalesController.class);

    @Autowired
    private ProfesionalesService profesionalesService;

//profesionales
//************************
    @PostMapping()
    public ResponseEntity<?> createProfesional(@RequestBody ProfesionalModel profesionalModel) throws Exception  {

        logger.info("Se da de alta profecional: " + profesionalModel.getDni());

        try {

            this.profesionalesService.crearProfesional(profesionalModel);

            return new ResponseEntity<ProfesionalModel>(profesionalModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> buscarProfesionalAll() throws Exception{

        logger.info("Se buscan todos los profesionales");

        try {

            List<ProfesionalModel> profesionales = this.profesionalesService.buscarProfesionalAll();

            return new ResponseEntity<List<ProfesionalModel>>(profesionales, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> buscarProfesionalByDNI(@PathVariable("dni") String dni) throws Exception{

        logger.info("Se busca profesional por dni: " + dni);

        try {

            ProfesionalModel profesional = this.profesionalesService.buscarProfesional(dni);

            return new ResponseEntity<ProfesionalModel>(profesional, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{idProfesional}")
    public ResponseEntity<?> buscarProfesionalById(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se busca profesional por id: " + idProfesional);

        try {

            ProfesionalModel profesional = this.profesionalesService.buscarProfesionalxId(idProfesional);

            return new ResponseEntity<ProfesionalModel>(profesional, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nomyape/{nombre}/{apellido}")
    public ResponseEntity<?> buscarProfesionalByNomYApe(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido) throws Exception{

        logger.info("Se busca profesional: " + nombre + ", " + apellido);

        try {

            List<ProfesionalModel> profesionales = this.profesionalesService.buscarProfesionalXNomYApe(nombre, apellido);

            return new ResponseEntity<List<ProfesionalModel>>(profesionales, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<?> buscarProfesionalByEspecialidad(@PathVariable("especialidad") String especialidad) throws Exception{

        logger.info("Se busca profesionales: " + especialidad);

        try {

            List<ProfesionalModel> profesionales = this.profesionalesService.buscarProfesionalXEspecialidad(especialidad);

            return new ResponseEntity<List<ProfesionalModel>>(profesionales, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idProfesional}")
    public ResponseEntity<?> modificarProfesional(@RequestBody ProfesionalModel profesionalModel, @PathVariable("idProfesional") Long idProfesional) throws Exception  {

        logger.info("Se modifica profesional: " + profesionalModel.getApellido() + ", " + profesionalModel.getNombre());

        try {
            ProfesionalModel profesional = this.profesionalesService.modificarProfesional(profesionalModel, idProfesional);

            return new ResponseEntity<ProfesionalModel>(profesional, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> borrarProfesional(@PathVariable("dni") String dni) throws Exception  {

        logger.info("Se elimina el profesional: " + dni);

        try {
            this.profesionalesService.borrarProfesional(dni);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//horarios
@PutMapping("/horario/{dni}")
public ResponseEntity<?> agregarHorarios(@PathVariable("dni") Long idProfesional, @RequestBody HorariosModel horariosModel) throws Exception  {

    logger.info("Se agrega horario para el profesional: " + idProfesional);

    try {
        this.profesionalesService.agregarHorarios(idProfesional, horariosModel);

        return new ResponseEntity<HorariosModel>(horariosModel, HttpStatus.CREATED);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}






}
