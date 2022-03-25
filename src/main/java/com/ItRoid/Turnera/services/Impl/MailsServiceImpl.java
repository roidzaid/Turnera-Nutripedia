package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.models.MailTurnoModel;
import com.ItRoid.Turnera.services.MailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service
public class MailsServiceImpl implements MailsService {

    private static String remitente = "roidzaid@gmail.com";
    private static String clave = "nhusznjjcuxrentv";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void enviarMailPaciente(MailTurnoModel mailTurnoModel) {

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
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTurnoModel.getMailPaciente()));   //Se podrían añadir varios de la misma manera
                message.setSubject("NUTRIPEDIA - Turno confirmado");

                String html = "";

                Map<String, String> mapInlineImages = new HashMap<String, String>();
                try{
                    mapInlineImages.put("logo", ResourceUtils.getURL("classpath:static/img/NUTRIPEDIA.jpeg").getPath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                html = crearPlantillaParaPaciente(mailTurnoModel);

                // creates message part
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(html, "text/html");

                // creates multi-part
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);

                if (mapInlineImages != null && mapInlineImages.size() > 0) {
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
                }

                message.setContent(multipart);

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, clave);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (MessagingException me) {
                me.printStackTrace();   //Si se produce un error
            }

    }

    @Override
    public void enviarMailProfecional(MailTurnoModel mailTurnoModel) {

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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTurnoModel.getMailProfecional()));   //Se podrían añadir varios de la misma manera
            message.setSubject("NUTRIPEDIA - Turno confirmado");

            String html = "";

            Map<String, String> mapInlineImages = new HashMap<String, String>();
            try{
                mapInlineImages.put("logo", ResourceUtils.getURL("classpath:static/img/NUTRIPEDIA.jpeg").getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            html = crearPlantillaParaProfesional(mailTurnoModel);

            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(html, "text/html");

            // creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (mapInlineImages != null && mapInlineImages.size() > 0) {
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
            }

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }


    private String crearPlantillaParaPaciente(MailTurnoModel mailTurnoModel){
        String html  ="<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table {\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "th, td {\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even){background-color: #f2f2f2}\n"
                + "\n"
                + "th {\n"
                + "  background-color: #31572C;\n"
                + "  color: white;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h2>Hola "+mailTurnoModel.getNombrePaciente()+"</h2>\n"
                + "\n"
                + "<h4>Le confirmamos el turno para el " +mailTurnoModel.getFecha() + " a las " +mailTurnoModel.getHora()+" hs con " +mailTurnoModel.getNombreProfecional()+"("+mailTurnoModel.getEspecialidad()+")"+"</h4>\n"
                + "\n"
                + "\n"
                + "<h4>De no poder asistir, o presentar sintomas compatibles con infeccion por COVID, por favor avisar al telefono "+mailTurnoModel.getTelefonoProfesional()+" con anterioridad</h4>\n"
                + "\n"
                + "<h4>Muchas gracias!!</h4>\n"
                + "\n"
                + "\n"
                + "</body>\n"
                + "</html>";

        return html;
    }


    private String crearPlantillaParaProfesional(MailTurnoModel mailTurnoModel){
        String html  ="<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table {\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "th, td {\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even){background-color: #f2f2f2}\n"
                + "\n"
                + "th {\n"
                + "  background-color: #31572C;\n"
                + "  color: white;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h2>Hola "+mailTurnoModel.getNombreProfecional()+"</h2>\n"
                + "\n"
                + "<h4>Hemos confirmado un turno para el dia " +mailTurnoModel.getFecha() + " a las " +mailTurnoModel.getHora()+" hs con " +mailTurnoModel.getNombrePaciente()+"("+mailTurnoModel.getDniPaciente()+") telefono: "+mailTurnoModel.getTelefonoPaciente()+"</h4>\n"
                + "\n"
                + "<h4>Motivo de la consulta:</h4>\n"
                + "<h4>"+mailTurnoModel.getTipoConsulta()+ " - " +mailTurnoModel.getMotivoConsulta()+"</h4>\n"
                + "\n"
                + "<h4>Muchas gracias!!</h4>\n"
                + "\n"
                + "\n"
                + "</body>\n"
                + "</html>";

        return html;
    }


}
