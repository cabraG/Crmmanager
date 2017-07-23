package com.neusoft.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Course;
import com.neusoft.domain.Page;
import com.neusoft.service.CourseService;
import com.neusoft.service.impl.CourseServiceImpl;
@WebServlet("/BeAddClassServlet")
public class BeAddClassServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public BeAddClassServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CourseService couse=new CourseServiceImpl();
		Course course=new Course();
		Page page=new Page();
		page=couse.getAllCoursePage(course,1,255);
		List<Course> courselist=new ArrayList<Course>();
		courselist=page.getCourselist();
		request.setAttribute("courselist", courselist);
		request.getRequestDispatcher("pages/classesm/addOrEditClass.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
