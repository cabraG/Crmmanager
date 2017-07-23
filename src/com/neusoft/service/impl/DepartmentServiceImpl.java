package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.DepartmentDao;
import com.neusoft.dao.impl.DepartmentDaoImpl;
import com.neusoft.domain.Department;
import com.neusoft.domain.Page;
import com.neusoft.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	@Override
	public Page getAllPageDep(Department department, int pagenum, int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setDeplist(departmentDao.getPageDepartment(department, pagenum, pagesize));
		page.setCount(departmentDao.getDepCount(department));
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
	return page;
	}

	@Override
	public void updateDep(Department department) {
		departmentDao.updateDep(department);
		}

	@Override
	public void insertDepName(Department department) {
	departmentDao.insertDep(department);
		
	}


}
