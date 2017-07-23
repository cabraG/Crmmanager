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
import com.neusoft.service.DepartmentService;
import com.neusoft.service.PostService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EditPostServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postid=request.getParameter("postId");
		Post post=new Post();
		
		PostService postse=new PostServiceImpl();
		post=postse.getDepPostbyPostId(postid);
		DepartmentService depse=new DepartmentServiceImpl();
		List<Department> departmentlist=depse.getAllDepartment();
		
		request.setAttribute("departmentList", departmentlist);
		request.setAttribute("posted", post);
		request.getRequestDispatcher("pages/post/addOrEditPost.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
