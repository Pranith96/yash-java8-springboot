package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;
import com.student.entity.Student;

public interface StudentService {

	String saveStudent(Student student);

	List<Student> getAllStudentRecords();

	Student getStudentData(Integer studentId);

	List<Student> getStudentsByNameDetails(String studentName);

	StudentDto getStudentsByLoginIdAndPassword(String loginId, String password);

	String deleteStudentData(Integer studentId);

	String updateName(String studentName, Integer studentId);

}
