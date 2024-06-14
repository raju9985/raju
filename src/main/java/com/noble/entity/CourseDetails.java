package com.noble.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="COURSE")
@Entity
public class CourseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID",length = 15)
	private Integer cid;
	
	@Column(name="COURSE_NAME",length = 50)
	private String cname;
	
}
