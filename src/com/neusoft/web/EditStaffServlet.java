package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Department;
import com.neusoft.domain.Post;
import com.neusoft.domain.Staff;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.PostService;
import com.neusoft.service.StaffService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
import com.neusoft.service.impl.StaffServiceImpl;

@WebServlet("/EditStaffServlet")
public class EditStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String staffId = request.getParameter("staffId");

		StaffService staffService = new StaffServiceImpl();
		DepartmentService departmentService = new DepartmentServiceImpl();
		PostService postService = new PostServiceImpl();
		
		Staff staff = staffService.getStaffById(staffId);
		List<Department> departmentList = departmentService.getAllDepartment();
		List<Post> postList = postService.getPostByDepId(staff.getDepId());
		
		request.setAttribute("staff", staff);
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("pages/staff/editStaff.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
