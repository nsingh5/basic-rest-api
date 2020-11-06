package com.narendra.springrestapi.contoller;

import java.net.http.HttpResponse;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/root")
@Api(value="Url mapping  rest",description="Url mapping rest description")
public class UrlMappingController {


	@GetMapping("/get")
	public String getMapping(@RequestHeader Map<String,String> headers) {
		return "test Pass :getMapping + headers :"+headers;
	}

	
	@PostMapping(value="/post",consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
	  public String postMapping(@RequestBody Student str)
	  { return "test Pass :postMapping "+str; }
	 
	
	@DeleteMapping("/delete")
	public String deleteMapping()
	{
		return "test Pass :deleteMapping";
	}
	
	@PutMapping("/put")
	public String putMapping(@RequestHeader HttpHeaders header ,HttpServletRequest req ,HttpServletResponse res) {
		res.setStatus(1899);
		return "test Pass :putMapping" + header.getAccept() + ",  " +req.getMethod()+",  " +res.getStatus();
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
