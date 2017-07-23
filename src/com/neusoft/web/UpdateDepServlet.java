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
@WebServlet("/UpdateDepServlet")
public class UpdateDepServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 传递数据对crm_department进行修改.
	 */
	public UpdateDepServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	Department department=new Department();
	DepartmentService depse=new DepartmentServiceImpl();
	department.setDepId(request.getParameter("depId"));
	department.setDepName(request.getParameter("depName"));
	depse.updateDep(department);
	response.sendRedirect("DeplistorFinddepServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
