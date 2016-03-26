package ua.com.emily.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ProductImageUpload {

	public static String getFileName(MultipartFile file) {
		return file.getOriginalFilename();
	}

	public static File fileUpload(MultipartFile uploadedFile) {

		/**
		 * Getting file's name
		 * 
		 * @path - the path to the folder preserving photos
		 *       getFileName(uploadedFile) - the image name will be passed to
		 *       the database
		 * 
		 */

		String path = "C:/Users/NoteBook/workAdvanceJava/EmilyProject/src/main/webapp/resources/img/portfolio/";

		String p = new String(path + getFileName(uploadedFile));
		File serverFile = new File(p);

		/*
		 * if (!serverFile.exists()) { try { serverFile.createNewFile();
		 * System.out.println("Successful create of the file - " +
		 * getFileName(uploadedFile)); } catch (IOException e) {
		 * System.out.println("Failed to create " + getFileName(uploadedFile));
		 * e.printStackTrace(); } }
		 */

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
