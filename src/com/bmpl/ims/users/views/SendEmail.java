package com.bmpl.ims.users.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	
  public SendEmail(String filename,ArrayList<String> list) {
      // Recipient's email ID needs to be mentioned.
	   String to[] = new String[list.size()];
	   
	   //Mail id you want to send;
		
	   
	  
	   for(int i=0;i<list.size();i++){
		   System.out.println("list email :"+list.get(i));
		   to[i]=(String) list.get(i);
	   }
	   InternetAddress[] address = new InternetAddress[to.length];
	   for(int i =0; i< to.length; i++)
	   {
	       try {
			address[i] = new InternetAddress(to[i]);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	    

      // Sender's email ID needs to be mentioned
      String from = "someyhing@gmail.com";

      final String username = "something@gmail.com";//change accordingly
      final String password = "okaysomething";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
    //  String host = "localhost";

      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
      props.put("mail.smtp.port", "587"); //TLS Port
      props.put("mail.smtp.auth", "true"); //enable authentication
      props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         for(String to1:to)
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to1));

         // Set Subject: header field
         message.setSubject("Testing Subject");
         message.setRecipients(Message.RecipientType.TO, address);

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("This is message body");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
    
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}