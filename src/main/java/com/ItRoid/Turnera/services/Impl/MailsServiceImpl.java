package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.controllers.FotoController;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

    @Override
    public void enviarMail(String destinatario, String plantilla) {

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
                message.setSubject("Espacio NUTRIPEDIA - Turno confirmado");

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
