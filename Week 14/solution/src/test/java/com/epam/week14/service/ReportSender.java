package com.epam.week14.service;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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

// As was agreed, here I am using a simple method with hardcoded values. It could be extended to support additional parameters
// such as more recipients etc., but I did not want to overcomplicate it without any need

public class ReportSender {
	
	private final static String USERNAME = "andriitestrudniktest@gmail.com";
	private final static String APP_PASSWORD = "oznuyjlsfgmoghmw";
	private final static String REPORT_LOCATION = "target/cucumber-report.html";
	
	public static void sendReport(String recipient) throws AddressException, MessagingException {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(USERNAME, APP_PASSWORD);
		    }
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("andriitestrudniktest@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		message.setSubject("Test Report " + TimeService.getCurrentTimeAsString());

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(REPORT_LOCATION)));
		mimeBodyPart.setFileName(REPORT_LOCATION);

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		message.setContent(multipart, "text/html");

		Transport.send(message);
	}
	
}
