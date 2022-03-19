package com.ItRoid.Turnera.controllers;

import com.ItRoid.Turnera.models.DiasDisponiblesModel;
import com.ItRoid.Turnera.models.EspecialidadModel;
import com.ItRoid.Turnera.services.EspecialidadService;
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

    Logger logger = LoggerFactory.getLogger(HorariosController.class);

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
}
