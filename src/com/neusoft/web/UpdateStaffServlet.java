package com.neusoft.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.domain.Staff;
import com.neusoft.service.StaffService;
import com.neusoft.service.impl.StaffServiceImpl;

@WebServlet("/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String staffId = request.getParameter("staffId");
			String loginName = request.getParameter("loginName");
			String loginPwd = request.getParameter("loginPwd");
			String staffName = request.getParameter("staffName");
			String gender = request.getParameter("gender");
			String onDutyDate = request.getParameter("onDutyDate");
			String postId = request.getParameter("postId");

			Staff staff = new Staff();
			staff.setStaffId(staffId);
			staff.setLoginName(loginName);
			staff.setLoginPwd(loginPwd);
			staff.setGender(gender);
			staff.setPostId(postId);
			staff.setStaffName(staffName);

			staff.setOnDutyDate(new SimpleDateFormat("yyyy-MM-dd").parse(onDutyDate));
			
			StaffService staffService = new StaffServiceImpl();
			
			staffService.updateStaffById(staff);
			
			response.sendRedirect("ListStaffServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
