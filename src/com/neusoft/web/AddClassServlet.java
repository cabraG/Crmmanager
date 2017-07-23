package com.neusoft.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.CrmClass;
import com.neusoft.service.ClassService;
import com.neusoft.service.impl.ClassServiceImpl;

@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddClassServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		String classname = request.getParameter("classname");
		String courseid = request.getParameter("courseid");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		String remark = request.getParameter("remark");
		CrmClass crmclass=new CrmClass();
		crmclass.setClassName(classname);
		crmclass.setCourseId(courseid);
		crmclass.setClassStart(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime));
		crmclass.setClassEnd(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
		crmclass.setRemark(remark);
		ClassService clsse=new ClassServiceImpl();
		clsse.insertClass(crmclass);
		response.sendRedirect("ListClassServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
