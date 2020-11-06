package com.narendra.springrestapi.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/input-controller")
@Api(value="input-controller mapping  rest",description="input-controller mapping rest description")
public class InputController {


	@GetMapping("/get-path-variable/{path-variable}")
	public String getMappingPathVariable(@PathVariable("path-variable") String pathVariable) {
		return "test Pass :getMapping + pathVariable :"+pathVariable;
	}

	@GetMapping("/get-query-param")
	public String getMappingQueryParam(@RequestParam("request-param") String queryParam) {
		return "test Pass :getMapping + request-param :"+queryParam;
	}
	
	
	///not work Get with body
	@GetMapping("/get-request-body")
	public String getMappingRequestBody(@RequestBody String requestBody) {
		return "test Pass :getMapping + requestBody :"+requestBody;
	}
	
	@PostMapping(value="/post/{path-variable}",consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) 
	  public String postMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str)
	  { return "test Pass :postMapping "+str+ " "+pathVariable+" "+queryParam; }
	 
	
	@DeleteMapping("/delete/{path-variable}")
	public String deleteMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str)
	{
		return "test Pass :deleteMapping "+str+ " "+pathVariable+" "+queryParam;
	}
	
	@PutMapping("/put/{path-variable}")
	public String putMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str,@RequestHeader HttpHeaders header ,HttpServletRequest req ,HttpServletResponse res) {
		res.setStatus(1899);
		return "test Pass :putMapping" + header.getAccept() + ",  " +req.getMethod()+",  " +res.getStatus()+ str+ " "+pathVariable+" "+queryParam;
	}
	
	
	@PatchMapping("/patch/{path-variable}")
	public String patchMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str) {
		return "test Pass :patchMapping "+str+ " "+pathVariable+" "+queryParam;
	}
	
	@RequestMapping("/request-mapping")
	public String requestMapping() {
		return "test Pass :requestMapping";
	}
	
}
