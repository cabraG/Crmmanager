package com.neusoft.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Department;

import com.neusoft.service.DepartmentService;

import com.neusoft.service.impl.DepartmentServiceImpl;

@WebServlet("/GetdpServlet")
public class GetdpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DepartmentService departmentService = new DepartmentServiceImpl();

		List<Department> departmentList = departmentService.getAllDepartment();

		request.setAttribute("departmentList", departmentList);

		request.getRequestDispatcher("pages/staff/addStaff.jsp").forward(
				request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
