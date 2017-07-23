package com.neusoft.service.impl;



import java.util.List;

import com.neusoft.dao.ClassDao;
import com.neusoft.dao.impl.ClassDaoImpl;
import com.neusoft.domain.CrmClass;
import com.neusoft.domain.Page;
import com.neusoft.service.ClassService;

public class ClassServiceImpl implements ClassService {
	ClassDao classdao=new ClassDaoImpl();

	@Override
	public Page getPageClass(int pagenum, int pagesize) {
		
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setCount(classdao.getCountClass());
		page.setClasslist(classdao.getPageClass(pagenum, pagesize));
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
		return page;
	}

	@Override
	public void insertClass(CrmClass crmClass) {
		classdao.insertClass(crmClass);
		
	}

	@Override
	public List<CrmClass> getCrmClassById(String classid) {
		// TODO Auto-generated method stub
		return classdao.selectClassByClassId(classid);
	}

}
