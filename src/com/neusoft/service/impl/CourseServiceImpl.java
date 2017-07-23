package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.CourseDao;
import com.neusoft.dao.impl.CourseDaoImpl;
import com.neusoft.domain.Course;
import com.neusoft.domain.Page;
import com.neusoft.service.CourseService;

public class CourseServiceImpl implements CourseService{
	private CourseDao courseDao = new CourseDaoImpl();
	@Override
	public Page getAllCoursePage(Course course, int pagenum, int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setCount(courseDao.getCourseCount(course));
		List<Course> courselist=courseDao.getPageCourse(course, pagenum, pagesize);
		page.setCourselist(courselist);
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
		return page;
	}
	@Override
	public void insertCourse(Course course) {
		courseDao.insertCourse(course);
		
	}
	@Override
	public Course selectOneCourse(String courseId) {
		return courseDao.getCourseById(courseId);
	}
	@Override
	public void updateCourse(Course course) {
	 courseDao.updateCourse(course);
		
	}

}
