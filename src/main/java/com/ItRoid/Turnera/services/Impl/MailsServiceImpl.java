package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.controllers.FotoController;
import com.ItRoid.Turnera.entities.*;
import com.ItRoid.Turnera.models.AsignarTurnoModel;
import com.ItRoid.Turnera.models.MailTurnoModel;
import com.ItRoid.Turnera.models.TurnoAsignadoModel;
import com.ItRoid.Turnera.plantillasMail.PlantillasMails;
import com.ItRoid.Turnera.repositories.*;
import com.ItRoid.Turnera.services.MailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MailsServiceImpl implements MailsService {

    Logger logger = LoggerFactory.getLogger(FotoController.class);

    @Value("${mail.nutripedia}")
    private String remitente;

    @Value("${clave.nutripedia}")
    private String clave;

    //private static String remitente = "roidzaid@gmail.com";
    //private static String clave = "nhusznjjcuxrentv";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TurnosAsignadosRepository turnosAsignadosRepository;

    @Autowired
    private ConfiguracionTurnosRepository configuracionTurnosRepository;

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private ProfesionalesRepository profesionalesRepository;

    @Autowired
    private ValorConsultaRepository valorConsultaRepository;

    @Autowired
    private PacientesRepository pacientesRepository;

    @Override
    public void prepararMails(AsignarTurnoModel asignarTurnoModel) {

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByidProfesional(asignarTurnoModel.getIdProfesional());

        PacienteEntity pacienteEntity = this.pacientesRepository.findByIdPaciente(asignarTurnoModel.getIdPaciente());

        ConfiguracionTurnosEntity configuracionTurnosEntity = this.configuracionTurnosRepository.findByIdConfiguracionTurno(asignarTurnoModel.getIdConfiguracionTurno());

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(asignarTurnoModel.getIdProfesional(), asignarTurnoModel.getTipoConsulta());

        if (valorConsultaEntity == null){
            List<ValorConsultaEntity> listaValorConsultaEntity = this.valorConsultaRepository.findByIdProfesional(asignarTurnoModel.getIdProfesional());

            valorConsultaEntity = listaValorConsultaEntity.get(0);
        }

        MailTurnoModel mailTurnoModel = new MailTurnoModel(
                pacienteEntity.getMail(),
                pacienteEntity.getNombre() + " " + pacienteEntity.getApellido(),
                pacienteEntity.getDni(),
                pacienteEntity.getTelefono(),
                profesionalEntity.getMail(),
                profesionalEntity.getNombre() + " " + profesionalEntity.getApellido(),
                profesionalEntity.getTelefono(),
                asignarTurnoModel.getEspecialidad(),
                profesionalEntity.getAliasMP(),
                asignarTurnoModel.getFecha(),
                configuracionTurnosEntity.getHora(),
                asignarTurnoModel.getTipoConsulta(),
                asignarTurnoModel.getMotivoConsulta(),
                valorConsultaEntity.getValorConsulta(),
                valorConsultaEntity.getValorDeSeña());

        PlantillasMails platilla = new PlantillasMails();

        String asunto = "Turno Agendado";

        //Enviar mail a paciente
        if (asignarTurnoModel.getTipoConsulta().equals("CONSULTA VIRTUAL")){
            enviarMail(pacienteEntity.getMail(), platilla.crearPlantillaParaPacienteTurnoVirtual(mailTurnoModel), asunto);
        }else{
            enviarMail(pacienteEntity.getMail(), platilla.crearPlantillaParaPaciente(mailTurnoModel), asunto);
        }

        //Enviar mail a profesional
        enviarMail(profesionalEntity.getMail(), platilla.crearPlantillaParaProfesional(mailTurnoModel), asunto);

    }

    @Override
    public void prepararMailsCancelacion(Long idTurnoAsignado) {

        TurnoAsignadoEntity turnoAsignado =  this.turnosAsignadosRepository.buscarTurnoXId(idTurnoAsignado);

        ProfesionalEntity profesionalEntity = this.profesionalesRepository.findByidProfesional(turnoAsignado.getIdProfesional());

        PacienteEntity pacienteEntity = this.pacientesRepository.findByIdPaciente(turnoAsignado.getIdPaciente());
        //enviar mail a paciente y profesional

        ValorConsultaEntity valorConsultaEntity = this.valorConsultaRepository.findByIdValorConsulta(turnoAsignado.getIdProfesional(), turnoAsignado.getTipoConsulta());

        if (valorConsultaEntity == null){
            List<ValorConsultaEntity> listaValorConsultaEntity = this.valorConsultaRepository.findByIdProfesional(turnoAsignado.getIdProfesional());

            valorConsultaEntity = listaValorConsultaEntity.get(0);
        }


        MailTurnoModel mailTurnoModel = new MailTurnoModel(
                pacienteEntity.getMail(),
                pacienteEntity.getNombre() + " " + pacienteEntity.getApellido(),
                pacienteEntity.getDni(),
                pacienteEntity.getTelefono(),
                profesionalEntity.getMail(),
                profesionalEntity.getNombre() + " " + profesionalEntity.getApellido(),
                profesionalEntity.getTelefono(),
                turnoAsignado.getEspecialidad(),
                profesionalEntity.getAliasMP(),
                turnoAsignado.getFecha(),
                turnoAsignado.getHora(),
                turnoAsignado.getTipoConsulta(),
                turnoAsignado.getMotivoConsulta(),
                valorConsultaEntity.getValorConsulta(),
                valorConsultaEntity.getValorDeSeña());

        PlantillasMails platilla = new PlantillasMails();

        String asunto = "Turno Cancelado";

        //Enviar mail a paciente
        enviarMail(pacienteEntity.getMail(), platilla.crearPlantillaParaPacienteCancelacion(mailTurnoModel), asunto);

        //Enviar mail a profesional
        enviarMail(profesionalEntity.getMail(), platilla.crearPlantillaParaProfesionalCancelacion(mailTurnoModel), asunto);
    }

    @Override
    public void enviarMail(String destinatario, String plantilla, String asunto) {

        logger.info("Se envian los mail");

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(remitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
                message.setSubject("Espacio NUTRIPEDIA - " + asunto);

                String html = "";

                Map<String, String> mapInlineImages = new HashMap<String, String>();
                try{
                    mapInlineImages.put("logo", ResourceUtils.getURL("classpath:static/img/NUTRIPEDIA.jpeg").getPath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                html = plantilla;

                // creates message part
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(html, "text/html");

                // creates multi-part
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);

                /*if (mapInlineImages != null && mapInlineImages.size() > 0) {
                    Set<String> setImageID = mapInlineImages.keySet();

                    for (String contentId : setImageID) {
                        MimeBodyPart imagePart = new MimeBodyPart();
                        imagePart.setHeader("Content-ID", "<" + contentId + ">");
                        imagePart.setDisposition(MimeBodyPart.INLINE);

                        String imageFilePath = mapInlineImages.get(contentId);
                        try {
                            imagePart.attachFile(imageFilePath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        multipart.addBodyPart(imagePart);
                    }
                }*/

                message.setContent(multipart);

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, clave);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (MessagingException me) {
                logger.info("error en el envio de mail: " + me);
                me.printStackTrace();   //Si se produce un error
            }

    }

}
