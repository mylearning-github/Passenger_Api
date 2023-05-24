package com.passenger.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.passenger.error.ErrorResponse;
import com.passenger.utility.Path;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors=ex.getBindingResult().getFieldErrors().stream().map(e->e.getField()+" : "+e.getDefaultMessage()).collect(Collectors.toList());
		String path = Path.getRequestUrl();
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), "validation errors", path,  errors);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PassengerNotFound.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> passengerNotFoundExceptionhandler(PassengerNotFound exception){
		List<String> errors = new ArrayList<>();
		errors.add(exception.getMessage());
		String path = Path.getRequestUrl();
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), "Not Found", path,  errors);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
}
