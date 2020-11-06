package com.narendra.springrestapi.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/output")
@Api(value="Response controller")
public class OutputController {


	@GetMapping(value="/get",produces ={MediaType.APPLICATION_XML_VALUE})
	public Student getMapping() {
		
		return new Student("naren", "XI", "IND");
	}
	
	
	@PostMapping(value="/post",produces ={MediaType.APPLICATION_XML_VALUE})
	public Student postMapping(@RequestBody Student s) {
		return s;
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<Student> deleteMapping() {
		return ResponseEntity.status(7999).contentType((MediaType.APPLICATION_XML)).body(new Student("naren", "XI", "IND"));
	}
	
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
	@PutMapping("/put")
	public String putMapping() {
		return "test Pass :putMapping";
	}
	
	
	@PatchMapping("/patch")
	public String patchMapping() {
		return "test Pass :patchMapping";
	}
	
	@RequestMapping("/request-mapping")
	public String requestMapping() {
		return "test Pass :requestMapping";
	}
	

	
}
