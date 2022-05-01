package com.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer >{
	//jpa query
	//List<Student> findByStudentName(String studentName);

	//@Query("select s from Student s where s.loginId=?1 and s.password=?2")
	//@Query("select s from Student s where s.loginId=:loginId and s.password=:password")
	Optional<Student> findByLoginIdAndPassword(String loginId, String password);

	//JPQL
	//@Query("select s from Student s where s.studentName=:studentName")
	//List<Student> getByStudentName(String studentName);
	
	//@Query("select s from Student s where s.studentName=?1")
	//List<Student> getByStudentName(String studentName);
	
	@Query(value = "select * from student_table where student_name=:studentName", nativeQuery = true)
	List<Student> getByStudentName(String studentName);

}
