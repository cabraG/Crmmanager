package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Post;
import com.neusoft.service.PostService;
import com.neusoft.service.impl.PostServiceImpl;
@WebServlet("/UpdatePostServlet")
public class UpdatePostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 传递数据对crm_post进行修改.
	 */
	public UpdatePostServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String depid=request.getParameter("depId");
		String postid=request.getParameter("postId");
		String postname=request.getParameter("postName");
		Post post=new Post();
		post.setPostId(postid);
		post.setDepId(depid);
		post.setPostName(postname);
		PostService postse=new PostServiceImpl();
		postse.updatePost(post);
		response.sendRedirect("PostListorFindServlet");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
