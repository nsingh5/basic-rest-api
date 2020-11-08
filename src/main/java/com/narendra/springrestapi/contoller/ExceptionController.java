package com.narendra.springrestapi.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import io.swagger.annotations.Api;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/exception")
@Api(value="Exception controller")
public class ExceptionController {

	@GetMapping("/get")
	public String getMapping() {
		int i=7/0;
		
		return "test Pass :getMapping";
	}
	
	
	@PostMapping("/post")
	public String postMapping() {
		throw HttpServerErrorException.create(HttpStatus.INTERNAL_SERVER_ERROR, "intentional", null, new byte[10], null);
		
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
	
	@DeleteMapping("/delete")
	public String deleteMapping(@Valid @RequestBody @NotNull Student str)
	{
		return "test Pass :deleteMapping "+str;
	}
}
