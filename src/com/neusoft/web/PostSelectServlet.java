package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Post;
import com.neusoft.service.PostService;
import com.neusoft.service.impl.PostServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/PostSelectServlet")
public class PostSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String depId = request.getParameter("depId");
		
		PostService postService = new PostServiceImpl();
		
		List<Post> list = postService.getPostByDepId(depId);
		
		JSONArray object = JSONArray.fromObject(list);
		
		response.getWriter().print(object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
