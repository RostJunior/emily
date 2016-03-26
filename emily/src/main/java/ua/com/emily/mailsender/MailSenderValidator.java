package ua.com.emily.mailsender;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class MailSenderValidator {

	/**
	 * Method validates the format of email address
	 * 
	 * @param email
	 *            - email entered by user
	 * @return true or false if email has the correct format
	 */
	public static boolean checkEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddress = new InternetAddress(email);
			emailAddress.validate();
		} catch (AddressException e) {
			result = false;
		}
		return result;
	}
}
