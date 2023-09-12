package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.MailTurnoModel;

public interface MailsService <T>{


    void prepararMails(AsignarTurnoModel asignarTurnoModel);

    void prepararMailsCancelacion(Long idTurnoAsignado);

    void enviarMail(String destinatario, String plantilla, String asunto);

}
