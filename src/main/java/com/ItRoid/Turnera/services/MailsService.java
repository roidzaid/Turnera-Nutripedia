package com.ItRoid.Turnera.services;

import com.ItRoid.Turnera.models.MailTurnoModel;

public interface MailsService <T>{

    void enviarMailPaciente(MailTurnoModel mailTurnoModel);

    void enviarMailProfecional(MailTurnoModel mailTurnoModel);
}
