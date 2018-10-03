package com.nisum.training.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	public List<String> getAllfileName() throws IOException, URISyntaxException{
		
		
		URL url = this.getClass().getClassLoader().getResource("");
		File folder = new File(url.toURI());
		File[] listOfFiles = folder.listFiles();
		List<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		    files.add(listOfFiles[i].getName());
		  } 
		}
		
		return files;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("Running ..");
		FileService ob= new FileService();
		try {
			ob.getAllfileName();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
