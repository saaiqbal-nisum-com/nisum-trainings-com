package com.nisum;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrainingController {
	@Autowired
	private FileService fileService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/page2")
    public String getPage2(){ 
           	return "page2";   
     }
	
	 @RequestMapping(value = "/page2/{value1}/{value2}", method = RequestMethod.GET)
	 @ResponseBody 
	  public Long addNumbers(@PathVariable("value1") Long value1,@PathVariable("value2") Long value2){
		 LOGGER.info("inside addNumbers method");
		 return value1 + value2;
	  } 
	
	@GetMapping("/page3")
    public String getPage3(Model model) throws IOException, URISyntaxException{
		List<String> files=fileService.getAllfileName();
		model.addAttribute("filelist", files);
		LOGGER.info(files.toString());
           	return "page3";        
     }	
}