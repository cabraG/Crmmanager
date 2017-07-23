package com.neusoft.domain;

import java.util.List;

public class Page {
	private int pagenum;
	private int pagesize;
	private int pages;
	private int count;
	private List<Staff> stafflist;
	private List<Department> deplist;
	private List<Post>  postlist;
	private List<Course> courselist;
	private List<CrmClass> classlist;
	private List<Students> studentlist;
	public List<Students> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<Students> studentlist) {
		this.studentlist = studentlist;
	}
	public List<CrmClass> getClasslist() {
		return classlist;
	}
	public void setClasslist(List<CrmClass> classlist) {
		this.classlist = classlist;
	}
	public List<Post> getPostlist() {
		return postlist;
	}
	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}
	public List<Department> getDeplist() {
		return deplist;
	}
	public void setDeplist(List<Department> deplist) {
		this.deplist = deplist;
	}
	public List<Staff> getStafflist() {
		return stafflist;
	}
	public void setStafflist(List<Staff> stafflist) {
		this.stafflist = stafflist;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Course> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	
	

}
