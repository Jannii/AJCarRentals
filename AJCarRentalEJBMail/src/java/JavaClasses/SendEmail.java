/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClasses;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bumblebee
 */
public class SendEmail {

    public void SendEmail(String receipiant, String body) {
        try {
            String from = "axelmalmberg1993@gmail.com";
            final String username = "axelmalmberg1993@gmail.com";//change accordingly
            final String password = "JohanAxel1";//change accordingly
            
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.getClass();
            
            Message mailMessage = new MimeMessage(mailSession);
            
            mailMessage.setFrom(new InternetAddress(from));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receipiant));
            mailMessage.setContent(body, "text/html");
            mailMessage.setSubject("NoReply-Order corfirmation");
            
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);
            
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
   
            
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

}
