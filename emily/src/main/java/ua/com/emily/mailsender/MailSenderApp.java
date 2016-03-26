package ua.com.emily.mailsender;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.multipart.MultipartFile;

public class MailSenderApp {

	/**
	 * Please, check and set parameters for the connection to the email-server
	 */
	final static String USERNAME = "rost_666@mail.ru";
	final static String PASSWORD = "uhy060186";

	// Sender of the mail
	final static String EMAILFROM = "rost_666@mail.ru";

	/**
	 * -------------------------------------------------------------------
	 * Method, which allows us to send the mail WITH attachment!
	 * 
	 * @param customerName
	 *            - the name of customer
	 * @param phoneNumber
	 *            - phone number
	 * @param email
	 *            - entered email to get the copy of mail
	 * @param question
	 *            - field for additional questions
	 * @param fileName
	 *            - the name of uploaded file
	 * @param file
	 *            - uploaded image file
	 */

	public static void sendMail(String customerName, String phoneNumber,
			String email, String question, String fileName, MultipartFile uploadedFile) {

		/**
		 * Setting for the connection to the mail server
		 */
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.mail.ru");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");

		/**
		 * Creating the new session in order to connect to server using settings
		 * shown above
		 */
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USERNAME, PASSWORD);
					}
				});

		try {

			/**
			 * Creating a MimeMessage Object
			 */
			MimeMessage message = new MimeMessage(session);

			/**
			 * Set the author of the message
			 */
			message.setFrom(new InternetAddress(EMAILFROM));

			/**
			 * Message delivery to server
			 */
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					EMAILFROM));

			/**
			 * Message's copy to the customer
			 */
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					email));

			/**
			 * Subject of message
			 */
			message.setSubject("New title from a customer!", "utf-8");

			/**
			 * Body part of the mail
			 */
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Customer's name is: " + "\n"
					+ customerName + "\n" + "His phone number is: " + "\n"
					+ phoneNumber + "\n" + "His email: " + "\n" + email + "\n"
					+ "Additional info: " + "\n" + question);

			/**
			 * Creating the multi-part message in order to add the attachment
			 */
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			/**
			 * This part is for the attachments
			 */
			messageBodyPart = new MimeBodyPart();

			/**
			 * Setting the source path to our attached file and adding the file
			 * to message body
			 */
			DataSource source = new FileDataSource(MailSenderFileUpload
					.fileUpload(uploadedFile).toString());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			/**
			 * Adding all multipart content to mail
			 */
			message.setContent(multipart);

			/**
			 * Sending message
			 */
			Transport.send(message);

			System.out.println("Message sent successfully...");
		} catch (MessagingException mex) {
			System.out.println("You have some problems with connection!");
		}

	}

	/**
	 * -------------------------------------------------------------------
	 * Method, which allows us to send the mail WITHOUT attachment!
	 * 
	 * @param customerName
	 *            - the name of customer
	 * @param phoneNumber
	 *            - phone number
	 * @param email
	 *            - entered email to get the copy of mail
	 * @param question
	 *            - field for additional questions
	 * @param fileName
	 *            - the name of uploaded file
	 * @param file
	 *            - uploaded image file
	 */

	public static void sendMail(String customerName, String phoneNumber,
			String email, String question) {

		/**
		 * Setting for the connection to the mail server
		 */
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");

		/**
		 * Creating the new session in order to connect to server using settings
		 * shown above
		 */
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USERNAME, PASSWORD);
					}
				});

		try {

			/**
			 * Creating a MimeMessage Object
			 */
			MimeMessage message = new MimeMessage(session);

			/**
			 * Set the author of the message
			 */
			message.setFrom(new InternetAddress(EMAILFROM));

			/**
			 * Message delivery to server
			 */
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					EMAILFROM));

			/**
			 * Message's copy to the customer
			 */
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					email));

			/**
			 * Subject of message
			 */
			message.setSubject("New title from a customer!");

			/**
			 * Body part of the mail
			 */
			message.setText("Customer's name is: " + "\n" + customerName + "\n"
					+ "His phone number is: " + "\n" + phoneNumber + "\n"
					+ "His email: " + "\n" + email + "\n" + "Additional info: "
					+ "\n" + question + "\n"
					+ "----- no attachment in this message -----");

			/**
			 * Sending message
			 */
			Transport.send(message);

			System.out
					.println("Message sent without attachment successfully...");
		} catch (MessagingException mex) {
			mex.printStackTrace();
			System.out.println("You have some problems with connection!");
		}

	}
}
