package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.domain.Post;
import com.neusoft.domain.Staff;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.PostService;
import com.neusoft.service.StaffService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
import com.neusoft.service.impl.StaffServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	/**
	 * staff高级查询
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String depId=request.getParameter("depId");
		String postId=request.getParameter("postId");
	    String staffName=request.getParameter("staffName");
	    Staff staff=new Staff();
	    Page page=new Page();
        HttpSession session = request.getSession();
		
		Object o1 = session.getAttribute("staffName");
		
		if(o1==null || staffName!=null) {
			session.setAttribute("staffName", staffName);
		} else {
			staffName = o1.toString();
		}
		
		Object o2 = session.getAttribute("postId");
		
		if(o2==null || postId!=null) {
			session.setAttribute("postId", postId);
		} else {
			postId = o2.toString();
		}
		
		Object o3 = session.getAttribute("depId");
		
		if(o3==null || depId!=null) {
			session.setAttribute("depId", depId);
		} else {
			depId = o3.toString();
		}
	  
	    staff.setDepId(depId);
	    staff.setPostId(postId);
	    staff.setStaffName(staffName);
	    StaffService service=new StaffServiceImpl();
	    PostService postService = new PostServiceImpl();
	    int pagenum=1;
	    String spageno=null;
		spageno=request.getParameter("pagen");
		pagenum=Integer.valueOf(spageno == null ? "1":spageno);
		
	    page=service.getFindStaff(staff,pagenum,3);
	    DepartmentService departmentService = new DepartmentServiceImpl();
	    List<Post> postList = postService.getPostByDepId(staff.getDepId());
	    List<Department> departmentList = departmentService.getAllDepartment();
	   
	    request.setAttribute("departmentList", departmentList);
	    request.setAttribute("postList", postList);
	    request.setAttribute("pageall", page);
	    request.setAttribute("staff", staff);
	    request.getRequestDispatcher("pages/staff/listStaff.jsp").forward(request, response);
	    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
