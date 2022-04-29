package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.TipoTurnoModel;
import com.ItRoid.Turnera.services.TipoTurnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("tipoTurno")
public class TipoTurnoController {

    Logger logger = LoggerFactory.getLogger(TipoTurnoController.class);

    @Autowired
    private TipoTurnoService tipoTurnoService;

    @GetMapping("/all")
    public ResponseEntity<?> buscarTiposTurnos() throws Exception{

        logger.info("Se listan los tipos de turnos:");

        try {

            List<TipoTurnoModel> tiposDeTurnos = this.tipoTurnoService.buscarTodos();

            return new ResponseEntity<List<TipoTurnoModel>>(tiposDeTurnos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
