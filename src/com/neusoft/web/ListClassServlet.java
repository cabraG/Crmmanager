package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Page;
import com.neusoft.service.ClassService;
import com.neusoft.service.impl.ClassServiceImpl;
@WebServlet("/ListClassServlet")
public class ListClassServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ListClassServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page page=new Page();
		int pagenum=1;
		String spageno=null;
		spageno=request.getParameter("pagen");
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		ClassService clse=new ClassServiceImpl();
		page=clse.getPageClass(pagenum, 3);
		request.setAttribute("pageAll", page);
		request.getRequestDispatcher("pages/classesm/listClass.jsp").forward(request, response);;
}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
