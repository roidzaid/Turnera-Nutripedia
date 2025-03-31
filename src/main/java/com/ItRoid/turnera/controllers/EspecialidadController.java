package com.ItRoid.turnera.controllers;

import com.ItRoid.turnera.models.EspecialidadModel;
import com.ItRoid.turnera.services.EspecialidadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("especialidades")
public class EspecialidadController {

    Logger logger = LoggerFactory.getLogger(EspecialidadController.class);

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/all")
    public ResponseEntity<?> buscarEspecialidades() throws Exception{

        logger.info("Se listan las especialidades:");

        try {

            List<EspecialidadModel> especilidades = this.especialidadService.buscarTodas();

            return new ResponseEntity<List<EspecialidadModel>>(especilidades, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idEspecialidad}")
    public ResponseEntity<?> buscarEspecialidades(@PathVariable("idEspecialidad") Long idEspecialidad) throws Exception{

        logger.info("Se busca espacialidad " + idEspecialidad);

        try {

            EspecialidadModel especialidadModel = this.especialidadService.buscarEspecialidad(idEspecialidad);

            return new ResponseEntity<EspecialidadModel>(especialidadModel , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createEspecialidad(@RequestBody EspecialidadModel especialidadModel) throws Exception  {

        logger.info("Se da de alta nueva especialidad: " + especialidadModel.getEspecialidad());

        try {

            this.especialidadService.crearEspecialidad(especialidadModel);

            return new ResponseEntity<EspecialidadModel>(especialidadModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{idEspecialidad}")
    public ResponseEntity<?> borrarEspecialidad(@PathVariable("idEspecialidad") Long idEspecialidad) throws Exception  {

        logger.info("Se elimina la especialidad " + idEspecialidad);

        try {
            this.especialidadService.eliminarEspecialidad(idEspecialidad);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idEspecialidad}")
    public ResponseEntity<?> modificarEspecialidad(@RequestBody EspecialidadModel especialidadModel, @PathVariable("idEspecialidad") Long idEspecialidad) throws Exception  {

        logger.info("Se modifica la especialidad " + especialidadModel.getEspecialidad());

        try {

            this.especialidadService.modificarEspecialidad(idEspecialidad, especialidadModel);

            return new ResponseEntity<EspecialidadModel>(especialidadModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
