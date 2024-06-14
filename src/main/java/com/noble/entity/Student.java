package com.noble.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="STD")
@Entity
public class Student extends CourseDetails{

	@Id
	@Column(name="STD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	
	@Column(name="SNAME",length = 50)
	private String sname;
	
	@Column(name="SFNAME",length = 50)
	private String sfname;
	
	@Column(name="QUALIFICATION",length = 15)
	private String Qualification;
	
	@Column(name = "LOCATION",length = 35 )
	private String location;
	
}
