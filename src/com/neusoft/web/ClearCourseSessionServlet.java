package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ClearCourseSessionServlet")
public class ClearCourseSessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ClearCourseSessionServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		HttpSession session =request.getSession(true);
			session.removeAttribute("courseName");
			session.removeAttribute("remark");
			session.removeAttribute("totalStart");
			session.removeAttribute("totalEnd");
			session.removeAttribute("lessonCostStart");
			session.removeAttribute("totalEnd");
			response.sendRedirect("CourseListAndFindServlet");
			

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
