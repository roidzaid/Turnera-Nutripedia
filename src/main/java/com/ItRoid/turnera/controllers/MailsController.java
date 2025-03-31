package com.ItRoid.turnera.controllers;

import com.ItRoid.turnera.models.AsignarTurnoModel;
import com.ItRoid.turnera.services.MailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("mails")
public class MailsController {

    Logger logger = LoggerFactory.getLogger(MailsController.class);

    @Autowired
    private MailsService mailsService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarMail(@RequestBody AsignarTurnoModel asignarTurnoModel) throws Exception  {

        logger.info("se envian mails");

        try {
            this.mailsService.prepararMails(asignarTurnoModel);

            return new ResponseEntity<AsignarTurnoModel>(asignarTurnoModel, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/enviarCancelacion/{idTurnoAsignado}")
    public ResponseEntity<?> enviarMailCancalacion(@PathVariable("idTurnoAsignado") Long idTurnoAsignado) throws Exception  {

        logger.info("se envian mails");

        try {
            this.mailsService.prepararMailsCancelacion(idTurnoAsignado);

            return new ResponseEntity<Long>(idTurnoAsignado, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
