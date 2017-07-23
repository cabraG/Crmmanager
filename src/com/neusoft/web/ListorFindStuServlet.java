package com.neusoft.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.domain.Course;
import com.neusoft.domain.CrmClass;
import com.neusoft.domain.Page;
import com.neusoft.domain.Students;
import com.neusoft.service.ClassService;
import com.neusoft.service.CourseService;
import com.neusoft.service.StudentService;
import com.neusoft.service.impl.ClassServiceImpl;
import com.neusoft.service.impl.CourseServiceImpl;
import com.neusoft.service.impl.StudentsServiceImpl;

@WebServlet("/ListorFindStuServlet")
public class ListorFindStuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListorFindStuServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetse = request.getParameter("condition");
		String stuclassid = request.getParameter("classId");
		String courseId = request.getParameter("courseId");
		int pagenum = 1;
		String spageno = null;
		spageno = request.getParameter("pagen");
		pagenum = Integer.valueOf(spageno == null ? "1" : spageno);
		HttpSession session = request.getSession();
		Object o1 = session.getAttribute("targetse");
		if (o1 == null || targetse != null) {
			session.setAttribute("targetse", targetse);
		} else {
			targetse = o1.toString();
		}

		Object o2 = session.getAttribute("stuclassid");
		if (o2 == null || stuclassid != null) {
			session.setAttribute("stuclassid", stuclassid);
		} else {
			stuclassid = o2.toString();
		}

		Object o3 = session.getAttribute("courseId");
		if (o3 == null || courseId != null) {
			session.setAttribute("courseId", courseId);
		} else {
			courseId = o3.toString();
		}

		Students students = new Students();
		students.setTargetse(targetse);
		students.setClassId(stuclassid);
		Page page = new Page();
		StudentService stuse = new StudentsServiceImpl();
		page = stuse.selectPageStu(students, pagenum, 3);
		request.setAttribute("pageall", page);
		CourseService couse = new CourseServiceImpl();
		Course course = new Course();
		ClassService clase = new ClassServiceImpl();
		if(courseId!=null){
		List<CrmClass> classlist = clase.getCrmClassById(courseId);
		request.setAttribute("classlist", classlist);
		}
		request.setAttribute("courselist",
				couse.getAllCoursePage(course, 1, 255).getCourselist());
		request.setAttribute("student", students);
		request.setAttribute("courseSelect", courseId);
		request.getRequestDispatcher("pages/student/listStudent.jsp").forward(
				request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
