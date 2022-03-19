package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;
import com.ItRoid.Turnera.models.TurnosDisponiblesModel;
import com.ItRoid.Turnera.services.TurnosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("turnos")
public class Turnoscontroller {

    Logger logger = LoggerFactory.getLogger(Turnoscontroller.class);

    @Autowired
    private TurnosService turnosService;

    @PostMapping("/asignar")
    public ResponseEntity<?> asignarTurno(@RequestBody AsignarTurnoModel asignarTurnoModel) throws Exception  {

        logger.info("Nuevo Turno para el paciente: " + asignarTurnoModel.getIdPaciente());

        try {
            this.turnosService.asignarTurno(asignarTurnoModel);

            return new ResponseEntity<AsignarTurnoModel>(asignarTurnoModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/disponibles/{fecha}/{idHorario}")
    public ResponseEntity<?> buscarTurnosLibre(@PathVariable("fecha") String fecha, @PathVariable("idHorario") Long idHorario) throws Exception{

        logger.info("Se listan horarios disponibles para la fecha: " + fecha);

        try {

            List<TurnosDisponiblesModel> turnosDisponibles = this.turnosService.turnosDisponibles(fecha, idHorario);

            return new ResponseEntity<List<TurnosDisponiblesModel>>(turnosDisponibles, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/misTurnos/{dniPaciente}")
    public ResponseEntity<?> misTurnos(@PathVariable("dniPaciente") String dniPaciente) throws Exception{

        logger.info("Se listan los turnos del paciente : " + dniPaciente);

        try {

            List<TurnoAsignadoModel> misTurnos = this.turnosService.misTurnos(dniPaciente);

            return new ResponseEntity<List<TurnoAsignadoModel>>(misTurnos, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
