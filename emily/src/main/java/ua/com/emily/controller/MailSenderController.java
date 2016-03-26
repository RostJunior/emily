package ua.com.emily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.emily.mailsender.MailSenderApp;
import ua.com.emily.mailsender.MailSenderFileUpload;
import ua.com.emily.mailsender.MailSenderValidator;

@Controller
public class MailSenderController {

	/**
	 * Method for reloading main page
	 * 
	 * @return the same page to send another post
	 */

	/**
	 * Controller for sendMail.jsp
	 * 
	 * @param customerName
	 *            - is the name of customer
	 * @param phoneNumber
	 *            - phone number
	 * @param email
	 *            - entered email to get the copy of mail
	 * @param question
	 *            - field for additional questions
	 * @param file
	 *            - image file
	 * @param model
	 *            - our user Model
	 * @return
	 */
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendMail(
			@RequestParam(value = "customerName") String customerName,
			@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "question") String question,
			@RequestParam(value = "pictureArray") MultipartFile uploadedFile) {

		/**
		 * Sending e-mail
		 */
		try {
			/**
			 * Cleaning phone number field from unnecessary data
			 */
			String phoneNumberString = phoneNumber.replaceAll("[^0-9]", "");

			/**
			 * This branch checks if there was entered the correct format of
			 * email. If correct then create entry in database and send email.
			 * If false - returns the page with warning.
			 */
			if (MailSenderValidator.checkEmailAddress(email) == true) {

				/**
				 * Sending email, using MailSenderApp.class and
				 * MailSenderFileUpload.class. Check if there is the file
				 * attached. If there is no file then use other overrided method
				 */

				if (!MailSenderFileUpload.getFileName(uploadedFile).isEmpty()) {
					MailSenderApp.sendMail(customerName, phoneNumberString,
							email, question,
							MailSenderFileUpload.getFileName(uploadedFile),
							uploadedFile);
				} else if (MailSenderFileUpload.getFileName(uploadedFile)
						.isEmpty()) {
					MailSenderApp.sendMail(customerName, phoneNumberString,
							email, question);
				}
			} else {
				return "/wrongData";
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			return "users/emptyData";
		}
		return "redirect:/emailsender?sendmail=success";
	}
}
