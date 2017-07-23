package com.neusoft.service.impl;

import com.neusoft.dao.StudentsDao;
import com.neusoft.dao.impl.StudentsDaoImpl;
import com.neusoft.domain.Page;
import com.neusoft.domain.Students;
import com.neusoft.service.StudentService;

public class StudentsServiceImpl implements StudentService{
	StudentsDao studao=new StudentsDaoImpl();

	@Override
	public Page selectPageStu(Students students, int pagenum, int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setStudentlist(studao.SelectStu(students, pagenum, pagesize));
		page.setCount(studao.getCountStu(students));
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
	    return page;
	}

}
