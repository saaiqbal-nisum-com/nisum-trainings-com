package com.nisum.training.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.training.service.FileService;

@RestController 
public class FileController {
	@Autowired
	private FileService fileService;
	
	@GetMapping(name ="/view")
	public List<String> getAllFileName() throws IOException, URISyntaxException{
		List<String> files=fileService.getAllfileName();
		return files;
	}
}
