package ua.com.emily.mailsender;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class MailSenderFileUpload {

	/**
	 * Method which allows to extract the name of the file from input field
	 * 
	 * @param file
	 * @return Name of the file
	 */
	public static String getFileName(MultipartFile file) {
		return file.getOriginalFilename();
	}

	/**
	 * Method for adding the file as attachment into mail
	 * 
	 * @param uploadedFile
	 *            - our input file
	 * @return File to upload
	 */
	public static File fileUpload(MultipartFile uploadedFile) {

		/**
		 * Getting file's name
		 */
		File serverFile = new File(getFileName(uploadedFile));

		if (!uploadedFile.isEmpty()) {
			try {
				/**
				 * Creating a byte-array for the uploaded file and store it in
				 * memory
				 */
				byte[] bytes = uploadedFile.getBytes();

				/**
				 * Now collect the byte-array to file and send it directly to
				 * the method that creates the mail
				 */
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.flush();
				stream.close();

				System.out.println("Successful upload of the file - "
						+ getFileName(uploadedFile));
			} catch (Exception e) {
				System.out.println("Failed to upload file - "
						+ getFileName(uploadedFile) + " >>> " + e.getMessage());
			}
		} else {
			System.out.println("Failed to upload " + getFileName(uploadedFile)
					+ " - empty file!");
			serverFile = null;
			return serverFile;
		}
		return serverFile;
	}
}
