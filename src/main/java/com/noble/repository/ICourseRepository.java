package com.noble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noble.entity.CourseDetails;

public interface ICourseRepository extends JpaRepository<CourseDetails, Integer> {

}
