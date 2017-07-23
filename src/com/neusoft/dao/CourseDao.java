package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.Course;

public interface CourseDao {
	public List<Course> getPageCourse(Course course,int pagenum,int pagesize);
	public int getCourseCount(Course course);
	public void insertCourse(Course course);
	public Course getCourseById(String courseId);
	public void updateCourse(Course course);
	
}
