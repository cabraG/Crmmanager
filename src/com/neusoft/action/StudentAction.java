package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Students>, SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Students students = new Students();
	private StudentService studentService = new StudentsServiceImpl();
	private int pagen;
	private Map<String, Object> session;
	private String courseId;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String listorfind() {
		Page page = new Page();
		String targetse = students.getTargetse();
		String classId = students.getClassId();
		String courseId = this.courseId;
		Students s = new Students();
		Object o1 = session.get("targetse");
		if (o1 == null || targetse != null) {
			session.put("targetse", targetse);
		} else {
			targetse = o1.toString();
		}

		Object o2 = session.get("classId");
		if (o2 == null || classId != null) {
			session.put("classId", classId);
		} else {
			classId = o2.toString();
		}

		Object o3 = session.get("courseId");
		if (o3 == null || courseId != null) {
			session.put("courseId", courseId);
		} else {
			courseId = o3.toString();
		}
		s.setTargetse(targetse);
		s.setClassId(classId);
		pagen = (pagen == 0 ? 1 : pagen);
		page = studentService.selectPageStu(s, pagen, 3);
		ActionContext.getContext().put("page", page);
		ClassService clase = new ClassServiceImpl();
		Course course = new Course();
		CourseService couse = new CourseServiceImpl();
		if(courseId!=null){
			List<CrmClass> classlist = clase.getCrmClassById(courseId);
			ActionContext.getContext().put("classlist", classlist);
			}
		ActionContext.getContext().put("courselist", couse.getAllCoursePage(course, 1, 255).getCourselist());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;
	}

	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return students;
	}

}
