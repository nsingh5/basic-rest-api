package com.narendra.springrestapi.contoller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/output")
@Api(value="Response controller")
public class OutputController {


	@GetMapping(value="/get",produces ={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Student getMapping() {
		
		return new Student("naren", "XI", "IND");
	}
	
	@GetMapping(value="/get2",produces ={MediaType.APPLICATION_JSON_VALUE})
	public Student getMapping2() {
		
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
	
	@RequestMapping(value="/request-mapping",method = RequestMethod.POST)
	public List<Student> requestMapping(@RequestBody List<Student> slist ) {
		return slist;
	}
	

	@RequestMapping(value="/request-mapping2",method = RequestMethod.GET)
	public List<Student> requestMapping3( ) {
		ArrayList< Student> b=new ArrayList<>();
		b.add(new Student("naren", "XI", "IND"));
		b.add(new Student("naren", "XI", "IND"));
		b.add(new Student("naren", "XI", "IND"));
		b.add(new Student("naren", "XI", "IND"));
		return b;
	}
	
}
