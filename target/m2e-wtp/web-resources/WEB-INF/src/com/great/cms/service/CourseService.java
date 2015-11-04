package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Course;

public interface CourseService {
	List<Course> getCourseList();
	public void addCourse(Course course);
	public void editCourse(Course course);
	public void deleteCourse(Course course);
	
	
}
