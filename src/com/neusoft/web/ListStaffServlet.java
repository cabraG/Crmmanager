package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;

import com.neusoft.service.DepartmentService;
import com.neusoft.service.StaffService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.StaffServiceImpl;

@WebServlet("/ListStaffServlet")
public class ListStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffService staffService = new StaffServiceImpl();
		Page page=new Page();
		int pagenum=1;
		String spageno=null;
		spageno=request.getParameter("pagen");
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		page = staffService.getStaffByPage(pagenum, 3);
		DepartmentService departmentService = new DepartmentServiceImpl();

		List<Department> departmentList = departmentService.getAllDepartment();

		request.setAttribute("departmentList", departmentList);
		request.setAttribute("pagel", page);
		
	
		request.getRequestDispatcher("pages/staff/listStaff.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
