package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.PacienteModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.services.PacientesService;
import com.ItRoid.Turnera.services.ProfesionalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("pacientes")
public class PacientesController {

    Logger logger = LoggerFactory.getLogger(PacientesController.class);

    @Autowired
    private PacientesService pacientesService;

    //Pacientes
//************************
    @PostMapping()
    public ResponseEntity<?> createPaciente(@RequestBody PacienteModel pacienteModel) throws Exception  {

        logger.info("Se da de alta paciente: " + pacienteModel.getDni());

        try {
            PacienteModel pacientel =  this.pacientesService.crearPaciente(pacienteModel);

            return new ResponseEntity<PacienteModel>(pacientel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> buscarPaciente(@PathVariable("dni") String dni) throws Exception{

        logger.info("Se busca paciente: " + dni);

        try {

            PacienteModel pacienteModel = this.pacientesService.BuscarPaciente(dni);

            return new ResponseEntity<PacienteModel>(pacienteModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{idPaciente}")
    public ResponseEntity<?> buscarPacientexId(@PathVariable("idPaciente") Long idPaciente) throws Exception{

        logger.info("Se busca paciente con id: " + idPaciente);

        try {

            PacienteModel pacienteModel = this.pacientesService.BuscarPacientexId(idPaciente);

            return new ResponseEntity<PacienteModel>(pacienteModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteModel pacienteModel) throws Exception  {

        logger.info("Se modifica paciente: " + pacienteModel.getIdPaciente());

        try {
            PacienteModel pacientel =  this.pacientesService.modificarPaciente(pacienteModel);

            return new ResponseEntity<PacienteModel>(pacientel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
