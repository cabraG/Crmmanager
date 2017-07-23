package com.neusoft.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class StaffAction extends ActionSupport implements ModelDriven<Staff>, SessionAware {
	private Staff staff = new Staff();

	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;
	}

	private int pagen;
	private StaffService staffService = new StaffServiceImpl();
	private Map<String, Object> session;
	private DepartmentService departmentService = new DepartmentServiceImpl();
	private PostService postService= new PostServiceImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {

		Staff s = staffService.loginStaff(staff);

		if (s == null) {
			addFieldError("", "用户名不存在或密码输入错误！");
			return LOGIN;
		}

		session.put("staff1", s);

		return SUCCESS;
	}
	public String loginout(){
		session.remove("staff1");
		
		return SUCCESS;
	}

	public String home() {
		return SUCCESS;
	}

	public String listStaff() {
		Page page = new Page();
		pagen = (pagen == 0 ? 1 : pagen);

		List<Department> departmentList = departmentService.getAllDepartment();
		page = staffService.getStaffByPage(pagen, 3);
		ActionContext.getContext().put("pageall", page);
		ActionContext.getContext().getValueStack().set("departmentList",departmentList);
		return SUCCESS;
	}

	public void postSelect() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PostService postService = new PostServiceImpl();
		String depId = staff.getDepId();
		List<Post> list = postService.getPostByDepId(depId);

		JSONArray object = JSONArray.fromObject(list);

		ServletActionContext.getResponse().getWriter().print(object);

	}
	

	public String staffFind() {
		Page page = new Page();
		String depId = staff.getDepId();
		String postId = staff.getPostId();
		String staffName = staff.getStaffName();
		pagen = (pagen == 0 ? 1 : pagen);
		
		

		Object o1 = session.get("staffName");

		if (o1 == null || staffName != null) {
			session.put("staffName", staffName);
		} else {
			staffName = o1.toString();
		}

		Object o2 = session.get("postId");

		if (o2 == null || postId != null) {
			session.put("postId", postId);
		} else {
			postId = o2.toString();
		}

		Object o3 = session.get("depId");

		if (o3 == null || depId != null) {
			session.put("depId", depId);
		} else {
			depId = o3.toString();
		}
		Staff findstaff = new Staff();
		findstaff.setDepId(depId);
		findstaff.setPostId(postId);
		findstaff.setStaffName(staffName);
		page = staffService.getFindStaff(findstaff, pagen, 3);
		List<Department> departmentList = departmentService.getAllDepartment();
		List<Post> postList = postService.getPostByDepId(findstaff.getDepId());
		ActionContext.getContext().put("staff", findstaff);
		ActionContext.getContext().put("pagefind", page);
		ActionContext.getContext().put("postlist",postList);
		ActionContext.getContext().getValueStack().set("departmentList", departmentList);

		return SUCCESS;

	}
	public String editStaff(){
		Staff s = staffService.getStaffById(staff.getStaffId());
		List<Department> departmentList = departmentService.getAllDepartment();
		List<Post> postList = postService.getPostByDepId(s.getDepId());
		ActionContext.getContext().put("staff",s);
		ActionContext.getContext().put("departmentList",departmentList);
		ActionContext.getContext().put("postList",postList);
		
		return SUCCESS;
	}
	
public String update(){
	staffService.updateStaffById(staff);
	

	return SUCCESS;
		}
public String add(){
	
	List<Department> departmentList = departmentService.getAllDepartment();
	ActionContext.getContext().put("departmentList",departmentList);
	return SUCCESS;
	
}
public String insert(){
	staffService.saveStaff(staff);
	return SUCCESS;
}

	@Override
	public Staff getModel() {
		
		return staff;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
