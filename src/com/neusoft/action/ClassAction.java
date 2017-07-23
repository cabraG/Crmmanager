package com.neusoft.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.neusoft.domain.Course;
import com.neusoft.domain.CrmClass;
import com.neusoft.domain.Page;
import com.neusoft.service.ClassService;
import com.neusoft.service.CourseService;
import com.neusoft.service.impl.ClassServiceImpl;
import com.neusoft.service.impl.CourseServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class ClassAction extends ActionSupport implements ModelDriven<CrmClass>, SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CrmClass crmClass=new CrmClass();
	private ClassService classService=new ClassServiceImpl();
	private int pagen;
	private Map<String, Object> session;
	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;
	}
	
	public String listorfind(){
		Page page = new Page();
		pagen = (pagen == 0 ? 1 : pagen);
		page=classService.getPageClass(pagen, 3);
		ActionContext.getContext().put("page", page);
		return SUCCESS;	
	}
public void ajaxCourseAndClass() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("application/json;charset=utf-8");
	
	ClassService clase = new ClassServiceImpl();
	List<CrmClass> list = clase.getCrmClassById(crmClass.getCourseId());
	JSONArray object = JSONArray.fromObject(list);
	response.getWriter().print(object);
	
	
	
	
}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}
public String add(){
	CourseService couse=new CourseServiceImpl();
	Course course=new Course();
	Page page=new Page();
	page=couse.getAllCoursePage(course,1,255);
	List<Course> courselist=new ArrayList<Course>();
	courselist=page.getCourselist();
	ActionContext.getContext().put("courselist", courselist);
	return SUCCESS;
}
public String insert(){
	classService.insertClass(crmClass);
	return SUCCESS;
	
}
	@Override
	public CrmClass getModel() {
		// TODO Auto-generated method stub
		return crmClass;
	}

}
