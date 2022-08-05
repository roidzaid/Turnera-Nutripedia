package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.entities.HorariosEntity;
import com.ItRoid.Turnera.models.ConfiguracionTurnoModel;
import com.ItRoid.Turnera.models.DiasAtencionModel;
import com.ItRoid.Turnera.models.DiasDisponiblesModel;
import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.services.HorariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("horarios")
public class HorariosController {

    Logger logger = LoggerFactory.getLogger(HorariosController.class);

    @Autowired
    private HorariosService horariosService;

    @GetMapping("/id/{idHorario}")
    public ResponseEntity<?> budcarHorario(@PathVariable("idHorario") Long idHorario) throws Exception{

        logger.info("se modifica el horario: " + idHorario);

        try {

            HorariosModel horariosModel = this.horariosService.buscarHorariosXId(idHorario);

            return new ResponseEntity<HorariosModel>(horariosModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{idHorario}")
    public ResponseEntity<?> modificarHorario(@PathVariable("idHorario") Long idHorario, @RequestBody HorariosModel horariosModel) throws Exception{

        logger.info("se modifica el horario: " + idHorario);

        try {

            HorariosModel horariosModel1 = this.horariosService.modificarHorario(idHorario, horariosModel);

            return new ResponseEntity<HorariosModel>(horariosModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/{idHorario}")
    public ResponseEntity<?> borrarHorarios(@PathVariable("idHorario") Long idHorario) throws Exception{

        logger.info("Se borrar el horario: " + idHorario);

        try {

            this.horariosService.borrarHorario(idHorario);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idHorario}")
    public ResponseEntity<?> buscarConfiguracionTurnos(@PathVariable("idHorario") Long idHorario) throws Exception{

        logger.info("Se buscar la configuracion de turnos para el horarios :" + idHorario);

        try {

            List<String> configuracionTurnos = this.horariosService.buscarConfiguracionTurnos(idHorario);

            return new ResponseEntity<List<String>>(configuracionTurnos, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("fechas/{idProfesional}/{tipoTurno}")
    public ResponseEntity<?> buscarFechas(@PathVariable("idProfesional") Long idProfesional, @PathVariable("tipoTurno") String tipoTurno) throws Exception{

        logger.info("Se busca las fechas para el profesional :" + idProfesional);

        try {

            List<DiasDisponiblesModel> diasDisponibles = this.horariosService.BuscarHorarios(idProfesional, tipoTurno);

            return new ResponseEntity<List<DiasDisponiblesModel>>(diasDisponibles, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("diasDeAtencion/{idProfesional}")
    public ResponseEntity<?> buscarFechas(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se buscas las fechas para el profesional :" + idProfesional);

        try {

            List<DiasAtencionModel> diasAtencion = this.horariosService.BuscarHorarios(idProfesional);

            return new ResponseEntity<List<DiasAtencionModel>>(diasAtencion, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("horariosTarjeta/{idProfesional}")
    public ResponseEntity<?> horariosTarjeta(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se buscas las fechas para el profesional :" + idProfesional);

        try {

            List<DiasAtencionModel> diasAtencion = this.horariosService.BuscarHorariosParaTarjeta(idProfesional);

            return new ResponseEntity<List<DiasAtencionModel>>(diasAtencion, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("configuracionTurno/{idConfiguracionTurno}")
    public ResponseEntity<?> buscarConfiguracionTurnoXId(@PathVariable("idConfiguracionTurno") Long idConfiguracionTurno) throws Exception{

        logger.info("Se buscar la configuracion del turno :" + idConfiguracionTurno);

        try {

            ConfiguracionTurnoModel configuracionTurnoModel = this.horariosService.buscarConfiguracionDeTurno(idConfiguracionTurno);

            return new ResponseEntity<ConfiguracionTurnoModel>(configuracionTurnoModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("tiposDeTurnos/{idProfesional}")
    public ResponseEntity<?> buscarTiposDeTurnos(@PathVariable("idProfesional") Long idProfesional) throws Exception{

        logger.info("Se buscas los tipos de turnos para el profesional :" + idProfesional);

        try {

            List<String> tiposTurnos = this.horariosService.buscarTiposDeTurno(idProfesional);

            return new ResponseEntity<List<String>>(tiposTurnos, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
