package com.noble.service;

import java.util.List;
import java.util.Map;

import com.noble.entity.Student;

public interface IStudentMgmntService {

	public String registerStudent(Student std); // to save Operations
	public Map<Long, String> getStudentdetails(); // to get student 
	public List<Student> showStudents(); // to view students list
	public Student getStudentById(Long stdid); // to get Students by student Id
	public String editStudent(Student std); // editing Students
	public String deleteStudent(Long stdId); // deteting Student
		
}
