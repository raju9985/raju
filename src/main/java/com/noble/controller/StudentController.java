package com.noble.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noble.entity.Student;
import com.noble.service.impl.StudentMgmntServiceImpl;

@RestController
@RequestMapping("/college")
public class StudentController {
	
	@Autowired
	private StudentMgmntServiceImpl stdService;

	@GetMapping("/show")
	public ResponseEntity<?> showStudentList(){
		try {
			Map<Long, String> stdMap = stdService.getStudentdetails();
			return new ResponseEntity<Map<Long,String>>(stdMap,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/register")
	public ResponseEntity<String> saveStudents(@RequestBody Student std){
		try {
			String msg = stdService.registerStudent(std);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/showall")
	public ResponseEntity<?> getAllStudents(){
		try {
			List<Student> sList = stdService.showStudents() ;
			return new ResponseEntity<List<Student>>(sList,HttpStatus.OK);  
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/find/{stdId}")
	public ResponseEntity<?> getStudentById(@PathVariable Long stdId)
	{
		try {
			Student std =stdService.getStudentById(stdId);
			return new ResponseEntity<Student>(std,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestBody Student std){
		
		try {
			String msg = stdService.editStudent(std);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{std}")
	public ResponseEntity<?> removeStudentById(@PathVariable Long std){
		
		try {
			String msg = stdService.deleteStudent(std);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
}
