package com.example;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/demo-service")
public class DemoController {

	@RequestMapping(value = "/some-resource", method = RequestMethod.PUT)
	public ResponseEntity<Void> put() {

		final HttpHeaders headers = new HttpHeaders();
		
		final ResponseEntity<Void> entity = new ResponseEntity<Void>(headers, HttpStatus.OK);
		
		return entity;
	}
	
}
