package com.neusoft.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.neusoft.domain.Course;
import com.neusoft.domain.Page;
import com.neusoft.service.CourseService;
import com.neusoft.service.impl.CourseServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseAction extends ActionSupport implements ModelDriven<Course>, SessionAware {
	private Course course = new Course();
	private int pagen;
	private CourseService courseService = new CourseServiceImpl();
	private Map<String, Object> session;

	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String listorfind() {
		Page page = new Page();
		pagen = (pagen == 0 ? 1 : pagen);
		String courseName = course.getCourseName();
		Course c = new Course();
		String summary = course.getSummary();
		String totalStart = course.getCourseTimeStart();
		String totalEnd = course.getCourseTimeEnd();
		String lessonCostStart = course.getCourseCastStart();
		String lessonCostEnd = course.getCourseCastEnd();

		Object o1 = session.get("courseName");
		if (o1 == null || courseName != null) {
			session.put("courseName", courseName);
		} else {
			courseName = o1.toString();
		}

		Object o2 = session.get("summary");
		if (o2 == null || summary != null) {
			session.put("summary", summary);
		} else {
			summary = o2.toString();
		}

		Object o3 = session.get("totalStart");
		if (o3 == null || totalStart != null) {
			session.put("totalStart", totalStart);
		} else {
			totalStart = o3.toString();
		}

		Object o4 = session.get("totalEnd");
		if (o4 == null || totalEnd != null) {
			session.put("totalEnd", totalEnd);
		} else {
			totalEnd = o4.toString();
		}

		Object o5 = session.get("lessonCostStart");
		if (o5 == null || lessonCostStart != null) {
			session.put("lessonCostStart", lessonCostStart);
		} else {
			lessonCostStart = o5.toString();
		}

		Object o6 = session.get("lessonCostEnd");
		if (o6 == null || lessonCostEnd != null) {
			session.put("lessonCostEnd", lessonCostEnd);
		} else {
			lessonCostEnd = o6.toString();
		}
		c.setCourseName(courseName);
		c.setSummary(summary);
		c.setCourseTimeStart(totalStart);
		c.setCourseTimeEnd(totalEnd);
		c.setCourseCastStart(lessonCostStart);
		c.setCourseCastEnd(lessonCostEnd);

		page = courseService.getAllCoursePage(c, pagen, 3);
		ActionContext.getContext().put("page", page);

		return SUCCESS;
	}
public String clearcourse(){
	ActionContext context=ActionContext.getContext();
	Map<String,Object> session=context.getSession();
	session.remove("courseName");
	session.remove("remark");
	session.remove("totalStart");
	session.remove("totalEnd");
	session.remove("lessonCostStart");
	session.remove("totalEnd");
	return SUCCESS;
}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
public String edit(){
	
	String courseid=course.getCourseId();
	
    course=courseService.selectOneCourse(courseid);
	ActionContext.getContext().put("course", course);
	
	return SUCCESS;
}
public String update(){
	courseService.updateCourse(course);
	return SUCCESS;
}
public String insert(){
	courseService.insertCourse(course);
	return SUCCESS;
}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
