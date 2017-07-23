package com.neusoft.action;

import java.util.Map;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.apache.struts2.interceptor.SessionAware;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>, SessionAware {
	
	private Department department=new Department();
	private String depName;
	private Map<String, Object> session;

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	private int pagen;

	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;
	}

	private DepartmentService departmentService = new DepartmentServiceImpl();

	private static final long serialVersionUID = 1L;

	public String deplist() {
		Page page=new Page();
		pagen = (pagen == 0 ? 1 : pagen);
		String depName=department.getDepName();
		Department d=new Department();
		Object o1 = session.get("depName");
		if (o1 == null || depName != null) {
			session.put("depName", depName);
		} else {
			depName = o1.toString();
		}
		d.setDepName(depName);
		page = departmentService.getAllPageDep(d, pagen, 3);
		
	
		ActionContext.getContext().put("page", page);

		return SUCCESS;

	}
	public String cleardep() throws Exception {
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		
		session.remove("depName");
		
		return SUCCESS;
	}
	public String edit(){
		Page page=new Page();
		page = departmentService.getAllPageDep(department, 1, 1);
		department=page.getDeplist().get(0);
		ActionContext.getContext().put("department",department);
		return SUCCESS;
	}
	public String update(){
		departmentService.updateDep(department);
		return SUCCESS;
		
	}
	public String insert(){
		departmentService.insertDepName(department);
	
		return SUCCESS;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
}
