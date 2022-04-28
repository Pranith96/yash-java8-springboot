package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	String saveStudent(Student student);

	List<Student> getAllStudentRecords();

	Student getStudentData(Integer studentId);

}
