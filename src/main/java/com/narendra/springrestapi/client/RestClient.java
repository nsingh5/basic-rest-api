package com.narendra.springrestapi.client;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narendra.springrestapi.contoller.Student;

import io.swagger.annotations.Api;

@RequestMapping("/client")
@RestController
@Api(value="rest client controller")
public class RestClient {

	RestTemplate restTemplate=new RestTemplate();

	@GetMapping(value="/get",produces ={MediaType.APPLICATION_XML_VALUE})
	public Student getMapping() {
		return restTemplate.getForEntity("http://localhost:9999/rest-api/output/get", Student.class).getBody();
	}
	
	
	@PostMapping(value="/post",produces ={MediaType.APPLICATION_XML_VALUE})
	public Student postMapping(@RequestBody Student s) {
		System.out.println(restTemplate.postForLocation("http://localhost:9999/rest-api/output/post",s, Student.class));
		return restTemplate.postForEntity("http://localhost:9999/rest-api/output/post",s, Student.class).getBody();
		
	}
	
	
	@DeleteMapping("/delete")
	public void deleteMapping() {
		 restTemplate.delete("http://localhost:9999/rest-api/output/delete");
		// return (ResponseEntity<Student>) ResponseEntity.ok();
	}
	
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
	@PutMapping("/put")
	public String putMapping() {
		return restTemplate.exchange("http://localhost:9999/rest-api/output/put", HttpMethod.PUT, null, String.class).getBody();
	}
	
	
	
	RequestCallback requestCallback(final Student updatedInstance) {
	    return clientHttpRequest -> {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.writeValue(clientHttpRequest.getBody(), updatedInstance);
	        clientHttpRequest.getHeaders().add(
	          HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	    };
	}
	
	@PatchMapping("/patch")
	public String patchMapping() {		
		return restTemplate.execute("http://localhost:9999/rest-api/output/post", HttpMethod.POST, requestCallback(new Student("naren", "XI", "IND")), clientHttpResponse->{System.out.println(clientHttpResponse);return clientHttpResponse.getBody();}).toString();
	}
	
	@RequestMapping(value="/request-mapping",method = RequestMethod.POST)
	public List<Student> requestMapping(@RequestBody List<Student> slist ) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(new Student("naren", "XI", "IND"));
		System.out.println(json);
			Student ss=mapper.readValue(json, Student.class);
		System.out.println(ss);
		
		String response=restTemplate.getForEntity("http://localhost:9999/rest-api/output/get2", String.class).getBody();
		System.out.println(mapper.readValue(response,Student.class));
		
		

		List<Student>  v= restTemplate.postForEntity("http://localhost:9999/rest-api/output/request-mapping",slist, List.class).getBody();
	return restTemplate.exchange("http://localhost:9999/rest-api/output/request-mapping2",HttpMethod.GET,null, List.class).getBody();
	}
	
	
}
