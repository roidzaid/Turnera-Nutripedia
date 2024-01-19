package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
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
            TurnoAsignadoModel turnoAsignadoModel = this.turnosService.asignarTurno(asignarTurnoModel);

            return new ResponseEntity<TurnoAsignadoModel>(turnoAsignadoModel, HttpStatus.CREATED);
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

    @GetMapping("/agenda/{idProfesional}")
    public ResponseEntity<?> agenda(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Buscar agenda de : " + idProfesional);

        try {

            List<TurnoAsignadoModel> agenda = this.turnosService.agenda(idProfesional);

            return new ResponseEntity<List<TurnoAsignadoModel>>(agenda, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/agendaGeneral")
    public ResponseEntity<?> agendaGeneral() throws Exception{

        logger.info("Buscar agenda general");

        try {

            List<TurnoAsignadoModel> agenda = this.turnosService.agendaGeneral();

            return new ResponseEntity<List<TurnoAsignadoModel>>(agenda, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/agenda/{idProfesional}/{fecha}")
    public ResponseEntity<?> agenda(@PathVariable("idProfesional") Long idProfesional, @PathVariable("fecha") String fecha) throws Exception{

        logger.info("Buscar agenda de : " + idProfesional);

        try {

            List<TurnoAsignadoModel> agenda = this.turnosService.agenda(idProfesional, fecha);

            return new ResponseEntity<List<TurnoAsignadoModel>>(agenda, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/agendaGeneral/{fecha}")
    public ResponseEntity<?> agenda(@PathVariable("fecha") String fecha) throws Exception{

        logger.info("Buscar agenda general por fecha ");

        try {

            List<TurnoAsignadoModel> agenda = this.turnosService.agendaGeneral(fecha);

            return new ResponseEntity<List<TurnoAsignadoModel>>(agenda, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idTurnoAsignado}")
    public ResponseEntity<?> cancelarTurno(@PathVariable("idTurnoAsignado") Long idTurnoAsignado) throws Exception{

        logger.info("Se cancela el turno: " + idTurnoAsignado);

        try {

            this.turnosService.cancelarTurno(idTurnoAsignado);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarTurno/{idTurnoAsignado}")
    public ResponseEntity<?> buscarTurno(@PathVariable("idTurnoAsignado") Long idTurnoAsignado) throws Exception{

        logger.info("Buscar turno : " + idTurnoAsignado);

        try {

            TurnoAsignadoModel turnoAsignadoModel = this.turnosService.buscarTurno(idTurnoAsignado);

            return new ResponseEntity<TurnoAsignadoModel>(turnoAsignadoModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idTurnoAsignado}")
    public ResponseEntity<?> marcarCobroSeña(@PathVariable("idTurnoAsignado") Long idTurnoAsignado) throws Exception  {

        logger.info("verificacion de la seña de turno manual: " + idTurnoAsignado);

        try {

            this.turnosService.marcarCobroSeña(idTurnoAsignado);

            return new ResponseEntity<Long>(idTurnoAsignado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{idTurnoAsignado}/{idPagoMP}/{estadoPago}")
    public ResponseEntity<?> marcarCobroSeña(@PathVariable("idTurnoAsignado") Long idTurnoAsignado, @PathVariable("idPagoMP") String idPagoMP, @PathVariable("estadoPago") String estadoPago) throws Exception  {

        logger.info("Se marca como cobrada la seña al turno: " + idTurnoAsignado);

        try {

            this.turnosService.marcarEstadoSeña(idTurnoAsignado, idPagoMP, estadoPago);

            return new ResponseEntity<Long>(idTurnoAsignado, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
