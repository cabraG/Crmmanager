package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Course;
import com.neusoft.service.CourseService;
import com.neusoft.service.impl.CourseServiceImpl;
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddCourseServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coursename=request.getParameter("courseName");
		String coursetime=request.getParameter("total");
		String coursecast=request.getParameter("courseCost");
		String summary=request.getParameter("remark");
		Course course= new Course();
		course.setCourseName(coursename);
		course.setCourseTime(coursetime);
		course.setCourseCast(coursecast);
		course.setSummary(summary);
		CourseService couse=new CourseServiceImpl();
		couse.insertCourse(course);
		response.sendRedirect("CourseListAndFindServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
