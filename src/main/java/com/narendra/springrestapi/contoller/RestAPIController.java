package com.narendra.springrestapi.contoller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="simple rest",description="simple rest description")
public class RestAPIController {

	@GetMapping("/get")
	public String getMapping() {
		return "test Pass :getMapping";
	}
	
	
	@PostMapping("/post")
	public String postMapping() {
		return "test Pass :postMapping";
	}
	
	
	@DeleteMapping("/delete")
	public String deleteMapping() {
		return "test Pass :deleteMapping";
	}
	
	
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
