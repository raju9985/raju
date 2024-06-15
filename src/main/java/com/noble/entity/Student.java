package com.noble.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Table(name="STD")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@Column(name="STD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;
	
	@Column(name="SNAME",length = 50)
	private String sname;
	
	@Column(name="SFNAME",length = 50)
	private String sfname;
	
	@Column(name="QUALIFICATION",length = 15)
	private String Qualification;
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Column(name = "LOCATION",length = 35 )
	private String location;
	
	
	
}
