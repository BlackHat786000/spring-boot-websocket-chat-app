package com.alibou.websocket.chat;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public static void sendEmail(String subject, String message) {
        // Sender's email address
        final String senderEmail = "yadavudit786@gmail.com";
        // Sender's email password
        final String senderPassword = "azpxuyuikwubkwrf";
        // Recipient's email address
        String recipientEmail = "yadavudit786@gmail.com";
        // SMTP server address for Gmail
        String smtpHost = "smtp.gmail.com";
        // SMTP server port for Gmail
        int smtpPort = 587;

        // Set mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            MimeMessage messageObj = new MimeMessage(session);

            // Set the sender and recipient email addresses
            messageObj.setFrom(new InternetAddress(senderEmail));
            messageObj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the email subject
            messageObj.setSubject(subject);

            // Set the email message
            messageObj.setText(message);

            // Send the message
            Transport.send(messageObj);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void send(String subject, String message) {
        EmailService.sendEmail(subject, message);
    }

}
