package com.narendra.springrestapi.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.narendra.springrestapi.contoller.Student;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {InternalServerError.class,ArithmeticException.class})
	public ResponseEntity internalServerError(Exception e,WebRequest wr) {
		return ResponseEntity.status(6770).body("intentional InternalServerError");
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	List<String> errors = ex.getBindingResult()
	    .getFieldErrors()
	    .stream()
	    .map(x -> x.getDefaultMessage())
	    .collect(Collectors.toList());

	Map<String, Object> body = new LinkedHashMap<>();
	body.put("errors", errors);
	return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/put/{path-variable}")
	public String putMapping(@PathVariable("path-variable") String pathVariable,@RequestParam("request-param") String queryParam,@RequestBody Student str,@RequestHeader HttpHeaders header ,HttpServletRequest req ,HttpServletResponse res) {
		return "test Pass :putMapping" + header.getAccept() + ",  " +req.getMethod()+",  " +res.getStatus()+ str+ " "+pathVariable+" "+queryParam;
	}
}
