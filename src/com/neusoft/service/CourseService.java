package com.neusoft.service;

import com.neusoft.domain.Course;
import com.neusoft.domain.Page;

public interface CourseService {
	public Page getAllCoursePage(Course course,int pagenum,int pagesize);
	public void insertCourse(Course course);
	public Course selectOneCourse(String courseId);
	public void updateCourse(Course course);
	
	
}
