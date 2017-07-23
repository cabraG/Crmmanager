package com.neusoft.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.impl.DepartmentServiceImpl;

@WebServlet("/EditDepServlet")
public class EditDepServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditDepServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String depid = request.getParameter("depId");
		Department dep = new Department();

		dep.setDepId(depid);
		Page page = new Page();
		DepartmentService depse = new DepartmentServiceImpl();
		page = depse.getAllPageDep(dep, 1, 1);
		dep=page.getDeplist().get(0);
		
		request.setAttribute("deped", dep);
		request.getRequestDispatcher("pages/department/addOrEditDepartment.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
