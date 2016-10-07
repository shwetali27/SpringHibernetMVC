/*
*@file_Name: FileUploadController.java
*@Author: Shwetali
*@Date: 07-10-2016
*@purpose: Program to upload file and storing uploaded file inside folder.
*/

package com.bridgelabz.controller;

import java.io.FileOutputStream;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	// specifing the folder location where we want to store the uploaded file
	private static final String UPLOAD_DIRECTORY = "/home/bridgelabz/Desktop/Shwetali/UploadMavenProject";

	// get method for file upload
	@RequestMapping("/uploadform")
	public ModelAndView uploadForm() {
		System.out.println("File upload get method");
		return new ModelAndView("uploadform");
	}

	// post method for file upload
	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam MultipartFile file, HttpSession session) throws Exception {
		// System.out.println("File upload post method");

		String filePath = UPLOAD_DIRECTORY + "/" + file.getOriginalFilename();
		System.out.println("File is Stored in: " + filePath);

		System.out.println("File size: " + file.getBytes().length + " Bytes");
		// System.out.println("File size1: "+file.getSize()+" Bytes");

		// coping file
		FileCopyUtils.copy(file.getBytes(), new FileOutputStream(filePath));

		return new ModelAndView("uploadform", "filesuccess", "File successfully saved!");
	}
}