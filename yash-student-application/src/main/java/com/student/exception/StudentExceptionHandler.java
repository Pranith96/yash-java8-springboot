package com.student.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setDetails("Student Records not found");
		response.setDateTime(LocalDateTime.now());
		response.setCode("AB123");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
}
