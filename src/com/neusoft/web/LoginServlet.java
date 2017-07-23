package com.neusoft.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Staff;
import com.neusoft.service.StaffService;
import com.neusoft.service.impl.StaffServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StaffService staffService = new StaffServiceImpl();
		
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		
		Staff staff = new Staff();
		staff.setLoginPwd(loginPwd);
		staff.setLoginName(loginName);
		
		//调用业务层的登录方法
		Staff s = staffService.loginStaff(staff);
		
		if(s==null) {//登录失败
			request.setAttribute("error", "用户名不存在或密码输入错误！");
			request.setAttribute("loginName", loginName);
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("staff1", s);
		response.sendRedirect("pages/frame.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
