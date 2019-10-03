package com.ing.products.controller;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ing.products.dto.ResponseVO;
import com.ing.products.service.UploadService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class UploadController {
	
	@Autowired
	UploadService uploadService;
	

	@PostMapping("/categories")
	public ResponseVO upload(@RequestParam("file") MultipartFile file) {
	
		String response = uploadService.upload(file);
		ResponseVO vo = new ResponseVO();
		vo.setStatusCode(HttpStatus.SC_OK);
		vo.setMessage(response);
		return vo;
	}

}
