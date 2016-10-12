/*
*@file name: FileDownloadController.java
*@Created By: Shwetali
*@Date: 12-10-2016
*@purpose: Downloading the file from internal and external storage
 			and save it into a perticular loaction given by user.
*/
package com.bridgelabz.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {

	// inside project, located in resources folder.
	private static final String INTERNAL_FILE = "irregular-verbs-list.pdf";

	// outside project, located in File system somewhere.
	private static final String EXTERNAL_FILE_PATH = "/home/bridgelabz/Pictures/Wallpapers/frog.jpg";

	@RequestMapping(value = "/info")
	public ModelAndView info() {
		String message = "Hello, This Program is to Download the file and store it inside a perticular folder";
		return new ModelAndView("info", "message", message);
	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "fileDownload";
	}

	@RequestMapping(value = "/download/{type}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {

		File file = null;

		// setting internal file
		if (type.equalsIgnoreCase("internal")) {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			file = new File(classloader.getResource(INTERNAL_FILE).getFile());

		}

		// setting external file
		else {
			file = new File(EXTERNAL_FILE_PATH);
		}

		if (!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		// getting MIME type of file
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		System.out.println("mimetype before : " + mimeType);

		//for default mime type
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		//Another method for MIME type
		/*FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimetype2 = fileNameMap.getContentTypeFor("file://" + file.getName());
		System.out.println(file.getName() + "-" + mimetype2);
		*/
		
		/*response.setContentType(mimeType);*/
		
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));
		/*response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));*/

		/*response.setContentLength((int) file.length());*/

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
		
	}
}
