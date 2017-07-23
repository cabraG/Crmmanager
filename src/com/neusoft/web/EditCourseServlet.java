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
@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditCourseServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Course course=new Course();
		String courseid=request.getParameter("courseId");
		CourseService couse=new CourseServiceImpl();
		course=couse.selectOneCourse(courseid);
		request.setAttribute("course", course);
		request.getRequestDispatcher("pages/coursetype/addOrEditCourse.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
