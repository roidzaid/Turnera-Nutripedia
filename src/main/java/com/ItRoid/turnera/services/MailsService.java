package com.ItRoid.turnera.services;

import com.ItRoid.turnera.models.AsignarTurnoModel;

public interface MailsService <T>{


    void prepararMails(AsignarTurnoModel asignarTurnoModel);

    void prepararMailsCancelacion(Long idTurnoAsignado);

    void enviarMail(String destinatario, String plantilla, String asunto);

}
