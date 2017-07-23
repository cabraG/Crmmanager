package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.Department;


public interface DepartmentDao {

	/**
	 * 查询所有的部门
	 * @return
	 */
	public List<Department> getAllDepartment();
	public List<Department> getPageDepartment(Department department,int pagenum,int pagesize);
	public int getDepCount(Department department);
public void updateDep(Department department);
public void insertDep(Department department);
	
}
