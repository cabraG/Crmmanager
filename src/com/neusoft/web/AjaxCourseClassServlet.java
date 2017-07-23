package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.neusoft.domain.CrmClass;
import com.neusoft.service.ClassService;
import com.neusoft.service.impl.ClassServiceImpl;

@WebServlet("/AjaxCourseClassServlet")
public class AjaxCourseClassServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AjaxCourseClassServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String couId = request.getParameter("couId");
		ClassService clase = new ClassServiceImpl();
		List<CrmClass> list = clase.getCrmClassById(couId);
		JSONArray object = JSONArray.fromObject(list);
		response.getWriter().print(object);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String couId = request.getParameter("couId");
		ClassService clase = new ClassServiceImpl();
		List<CrmClass> list = clase.getCrmClassById(couId);
		JSONArray object = JSONArray.fromObject(list);
		response.getWriter().print(object);

	}

}
