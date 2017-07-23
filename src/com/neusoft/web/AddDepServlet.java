package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Department;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.impl.DepartmentServiceImpl;

@WebServlet("/addDepServlet")
public class AddDepServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddDepServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Department department = new Department();
		DepartmentService depse = new DepartmentServiceImpl();
		String depname = request.getParameter("depName");
		if (depname == "") {
			request.setAttribute("note", "部门名不能为空");
			request.getRequestDispatcher(
					"pages/department/addOrEditDepartment.jsp").forward(
					request, response);
		}
		department.setDepName(depname);
		depse.insertDepName(department);
		response.sendRedirect("DeplistorFinddepServlet");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
