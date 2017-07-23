package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.impl.DepartmentServiceImpl;
@WebServlet("/DeplistorFinddepServlet")
public class DeplistorFinddepServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DeplistorFinddepServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   
	
		DepartmentService departmentService = new DepartmentServiceImpl();
		Page page=new Page();
		Department department=new Department();
 	    int pagenum=1;
		String spageno=null;
		String depname=request.getParameter("depName");
		spageno=request.getParameter("pagen");
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		department.setDepName(depname);
		HttpSession session = request.getSession();
		Object o1 = session.getAttribute("depName");
		if(o1==null || depname!=null) {
			session.setAttribute("depName",depname);
		}else
		{depname=o1.toString();}
		
		page = departmentService.getAllPageDep(department, pagenum, 3);
	
		request.setAttribute("pageall",page);
		request.getRequestDispatcher("pages/department/listDepartment.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
