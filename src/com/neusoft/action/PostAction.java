package com.neusoft.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.domain.Post;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.PostService;
import com.neusoft.service.impl.DepartmentServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<Post>, SessionAware {
	private Post post = new Post();
	private int pagen;
	private Map<String, Object> session;
	private PostService postse = new PostServiceImpl();
	private DepartmentService depse = new DepartmentServiceImpl();
	/**
	 * Post
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String listorfind() {
		Page page = new Page();
		Post p = new Post();
		String depid = post.getDepId();
		String postname = post.getPostName();
		pagen = (pagen == 0 ? 1 : pagen);
		Object o1 = session.get("depId");
		if (o1 == null || depid != null) {
			session.put("depId", depid);
		} else {
			depid = o1.toString();
		}
		Object o2 = session.get("postName");
		if (o2 == null || postname != null) {
			session.put("postName", postname);
		} else {
			postname = o2.toString();
		}
		p.setDepId(depid);
		p.setPostName(postname);
		page = postse.getPagePostList(p, pagen, 3);
		ActionContext.getContext().put("post", p);
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("departmentList", depse.getAllDepartment());

		return SUCCESS;

	}
	public String clearpost(){
		ActionContext context=ActionContext.getContext();
		Map<String,Object> session=context.getSession();
		
		session.remove("depId");
		session.remove("postName");
		
		
		
		
		return SUCCESS;
		
	}
public String edit(){
	String postid=post.getPostId();
	Post p=new Post();
	p=postse.getDepPostbyPostId(postid);
	DepartmentService depse=new DepartmentServiceImpl();
	List<Department> departmentlist=depse.getAllDepartment();
	ActionContext.getContext().put("post", p);
	ActionContext.getContext().put("departmentList", departmentlist);
	return SUCCESS;
	
}
public String update(){
	postse.updatePost(post);
	return SUCCESS;
	
}
public String add(){
	List<Department> departmentlist=depse.getAllDepartment();
	ActionContext.getContext().put("departmentList", departmentlist);
	return SUCCESS;
	
}
public String insert(){
	postse.insertPost(post);
	return SUCCESS;
}
	@Override
	
	public Post getModel() {
		// TODO Auto-generated method stub
		return post;
	}

	public int getPagen() {
		return pagen;
	}

	public void setPagen(int pagen) {
		this.pagen = pagen;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
