package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String response = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> response = studentService.getAllStudentRecords();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable("studentId") Integer studentId) {
		Student response = studentService.getStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/name")
	public ResponseEntity<List<Student>> getStudentsByName(@RequestParam("studentName") String studentName) {
		List<Student> response = studentService.getStudentsByNameDetails(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/login")
	public ResponseEntity<StudentDto> getStudentsByLoginIdAndPassword(@RequestParam("loginId") String loginId,
			@RequestParam("password") String password) {
		StudentDto response = studentService.getStudentsByLoginIdAndPassword(loginId,password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer studentId) {
		String response = studentService.deleteStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/update/{studentName}/{studentId}")
	public ResponseEntity<String> updateStudentName(@PathVariable("studentName") String studentName, @PathVariable("studentId") Integer studentId){
		String response = studentService.updateName(studentName,studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
