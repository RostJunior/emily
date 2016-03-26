package ua.com.emily.mailsender;

import java.util.List;
import java.util.Properties;





import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




import ua.com.emily.domain.Cart;



public class MailSenderOrder {

	/**
	 * Please, check and set parameters for the connection to the email-server
	 */
	final static String USERNAME = "rost_666@mail.ru";
	final static String PASSWORD = "uhy060186";

	// Sender of the mail
	final static String EMAILFROM = "rost_666@mail.ru";


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

	public static void sendMail(String nameUsers, String phoneNumberUsers,
			String emailUser, List<Cart> carts, int total, String dostavka) {

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
					emailUser));

			/**
			 * Subject of message
			 */
			message.setSubject("New title from a customer!", "utf-8");

			/**
			 * Body part of the mail
			 */
			
			String s = "";
			for (Cart cart : carts) {
				s+= cart.toString() + "\n";
			}
			
					
			message.setText(""
					+ "\nCustomer's name is: \n"
					+ "\n" + nameUsers + "\n"
					+ "His phone number is: "
					+ "\n" + phoneNumberUsers + "\n"
					+ "His email: " + "\n"
					+ emailUser + "\n" 
					+ "Additional info: "
					+ "\n" 
					+ s 
					+ "Summa= "
					+ 
					total
					
					+ "\n"
					
					+ 
					"Dostavka = " + dostavka + "\n"
					+"\n----- no attachment in this message -----\n");
			
			
			
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
