package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.Department;
import com.neusoft.domain.Page;

public interface DepartmentService {

	/**
	 * 查询所有的部门
	 * @return
	 */
	public List<Department> getAllDepartment();
	
	public Page getAllPageDep(Department department,int pagenum,int pagesize);
	
	public void updateDep(Department department);
	
	public void insertDepName(Department department);
}
