package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.domain.Course;

import com.neusoft.domain.Page;
import com.neusoft.service.CourseService;
import com.neusoft.service.impl.CourseServiceImpl;
@WebServlet("/CourseListAndFindServlet")
public class CourseListAndFindServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CourseListAndFindServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("courseName");
		String remark=request.getParameter("remark");
		String totalStart=request.getParameter("totalStart");
		String totalEnd=request.getParameter("totalEnd");
		String lessonCostStart=request.getParameter("lessonCostStart");
		String lessonCostEnd=request.getParameter("lessonCostEnd");
		CourseService couse=new CourseServiceImpl();
		Course course=new Course();
		course.setCourseName(courseName);
		course.setSummary(remark);
		course.setCourseTimeStart(totalStart);
		course.setCourseTimeEnd(totalEnd);
		course.setCourseCastStart(lessonCostStart);
		course.setCourseCastEnd(lessonCostEnd);
		HttpSession session = request.getSession();
		Object o1 = session.getAttribute("courseName");
		if(o1==null || courseName!=null) {
			session.setAttribute("courseName",courseName);
		}else
		{courseName=o1.toString();}
		
		Object o2 = session.getAttribute("remark");
		if(o2==null || remark!=null) {
			session.setAttribute("remark",remark);
		}else
		{remark=o2.toString();}
		
		Object o3 = session.getAttribute("totalStart");
		if(o3==null || totalStart!=null) {
			session.setAttribute("totalStart",totalStart);
		}else
		{totalStart=o3.toString();}
		
		Object o4 = session.getAttribute("totalEnd");
		if(o4==null || totalEnd!=null) {
			session.setAttribute("totalEnd",totalEnd);
		}else
		{totalEnd=o4.toString();}
		
		Object o5 = session.getAttribute("lessonCostStart");
		if(o5==null || lessonCostStart!=null) {
			session.setAttribute("lessonCostStart",lessonCostStart);
		}else
		{lessonCostStart=o5.toString();}
		
		Object o6 = session.getAttribute("lessonCostEnd");
		if(o6==null || lessonCostEnd!=null) {
			session.setAttribute("lessonCostEnd",lessonCostEnd);
		}else
		{lessonCostEnd=o6.toString();}
		
		Page page=new Page();
	    int pagenum=1;
		String spageno=null;
		spageno=request.getParameter("pagen");
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		page=couse.getAllCoursePage(course, pagenum, 3);
		request.setAttribute("course", course);
		request.setAttribute("pageall", page);
		request.getRequestDispatcher("pages/coursetype/listCourse.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
