package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.repository.StudentRepository;

@Service
@Transactional
@Profile(value= {"dev","local","qa"})
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public String saveStudent(Student student) {

		Student response = studentRepository.save(student);
		if (response == null) {
			return "data is not saved";
		}

		return "Data is saved successfully";
	}

	@Override
	public List<Student> getAllStudentRecords() {
		List<Student> response = studentRepository.findAll();
		if (response == null || response.isEmpty()) {
			throw new StudentNotFoundException("student records empty");
		}
		return response;
	}

	@Override
	public Student getStudentData(Integer studentId) {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("id doesnt exists");
		}
		return response.get();
	}

	@Override
	public List<Student> getStudentsByNameDetails(String studentName) {
		// jpa query
		// List<Student> response = studentRepository.findByStudentName(studentName);
		List<Student> response = studentRepository.getByStudentName(studentName);
		if (response == null || response.isEmpty()) {
			throw new StudentNotFoundException("student records not found for given name");
		}
		return response;
	}

	@Override
	public StudentDto getStudentsByLoginIdAndPassword(String loginId, String password) {
		Optional<Student> response = studentRepository.findByLoginIdAndPassword(loginId, password);
		if (!response.isPresent()) {
			throw new RuntimeException("Login id or password Incorrect");
		}
		StudentDto dto = new StudentDto();
		dto.setStudentId(response.get().getStudentId());
		dto.setStudentName(response.get().getStudentName());
		dto.setMobileNumber(response.get().getMobileNumber());
		dto.setEmail(response.get().getEmail());
		return dto;
	}

	@Override
	public String deleteStudentData(Integer studentId) {
		// studentRepository.deleteById(studentId);
		Student response = getStudentData(studentId);
		studentRepository.delete(response);
		return "deleted successfully";
	}

	@Transactional
	@Override
	public String updateName(String studentName, Integer studentId) {
		studentRepository.updateStudentName(studentName, studentId);
		return "updated successfully";
	}

}
