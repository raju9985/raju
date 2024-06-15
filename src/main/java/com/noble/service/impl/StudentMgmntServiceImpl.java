package com.noble.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noble.entity.CourseDetails;
import com.noble.entity.Student;
import com.noble.repository.ICourseRepository;
import com.noble.repository.IStudentRepository;
import com.noble.service.ICourseMgntService;
import com.noble.service.IStudentMgmntService;

@Service
public class StudentMgmntServiceImpl implements IStudentMgmntService {

	@Autowired
	private IStudentRepository studRepo;
	
	@Autowired
	private ICourseRepository courseRepo;
	
	
	@Override
	public String registerStudent(Student std) {
		 
		Student str = studRepo.save(std);
		if(str.getSid()!=null) {
			return "Student record saved "+str.getSid();
		}
		else 	

		return "Student record Not saved"+str.getSid();
	}

	

	@Override
	public List<Student> showStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentById(Long stdid) {
		Optional<Student> stud = studRepo.findById(stdid);
		if(stud.isPresent()) {
			
		return stud.get();
		}
		else
	{
		throw new IllegalArgumentException("Student Id not Found");
	}
	}

	@Override
	public String editStudent(Student std) {
		Optional<Student> stud = studRepo.findById(std.getSid());
		if(stud.isPresent())
		{
			studRepo.save(std);
			return std.getSid()+"Student is saved";
		}
		else {
			
			return std.getSid()+"student is not saved";
		}
		
	}

	@Override
	public String deleteStudent(Long stdId) {
		Optional<Student> std = studRepo.findById(stdId);
		if(std.isPresent())
		{
			studRepo.deleteById(stdId);
			return stdId+" Student Id deleted";
		}
		else {
			return stdId+ " Student Id Not deleted";
		}
	
	}

	@Override
	public Map<Long, String> getStudentdetails() {
		// GET aLL Students
		List<Student> stdList = studRepo.findAll();
		Map<Long, String> studMap= new HashMap<Long, String>();
		stdList.forEach(stud->{
			studMap.put(stud.getSid(), stud.getSname());
		});
		return studMap;
	}

}
