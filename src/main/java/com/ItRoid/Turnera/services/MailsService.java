package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.MailTurnoModel;

public interface MailsService <T>{

    void enviarMail(String destinatario, String plantilla);

}
