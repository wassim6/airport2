package edu.esprit.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



@Stateless
@LocalBean
public class GwMessage {

 
@Resource(mappedName="java:jboss/mail/Gmail")
Session gmailSession;
 
     public GwMessage() {
    }
    
    @Asynchronous
    public void sendEmail(String to, String from, String subject, String content) {
     
    	Logger.getLogger(getClass().getName())
		.log(Level.INFO,"Sending Email from " + from + " to " + to + " : " + subject);
     
  try {
 
   Message message = new MimeMessage(gmailSession);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(to));
   message.setSubject(subject);
   message.setText(content);
 
   Transport.send(message);
 
   Logger.getLogger(getClass().getName())
	.log(Level.INFO,"Email was sent");
 
  } catch (MessagingException e) {
	  Logger.getLogger(getClass().getName())
		.log(Level.INFO,"Error while sending email : " + e.getMessage());
  }
    }

}
