package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.domain.Page;
import com.neusoft.domain.Post;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.PostService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
@WebServlet("/PostListorFindServlet")
public class PostListorFindServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public PostListorFindServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page=new Page();
	PostService postse=new PostServiceImpl();
	DepartmentService depse=new DepartmentServiceImpl();
	Post post=new Post();
	 int pagenum=1;
		String spageno=null;
		spageno=request.getParameter("pagen");
		String depid=request.getParameter("depId");
		String postname=request.getParameter("postName");
		HttpSession session = request.getSession();
		Object o1 = session.getAttribute("depId");
		if(o1==null || depid!=null) {
			session.setAttribute("depId",depid);
		}else
		{depid=o1.toString();}
		Object o2 = session.getAttribute("postName");
		if(o2==null || postname!=null) {
			session.setAttribute("postName",postname);
		}else
		{postname=o2.toString();}
		
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		post.setDepId(depid);
		post.setPostName(postname);
		page=postse.getPagePostList(post, pagenum, 3);
		request.setAttribute("departmentList", depse.getAllDepartment());
		request.setAttribute("post", post);
		request.setAttribute("pageall",page);
	    request.getRequestDispatcher("pages/post/listPost.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
