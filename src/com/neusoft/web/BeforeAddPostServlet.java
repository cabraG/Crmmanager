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
@WebServlet("/BeforeAddPostServlet")
public class BeforeAddPostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public BeforeAddPostServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DepartmentService depse=new DepartmentServiceImpl();
		List<Department>deplist=depse.getAllDepartment();
		request.setAttribute("departmentList",deplist);
		request.getRequestDispatcher("pages/post/addOrEditPost.jsp").forward(request, response);;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
