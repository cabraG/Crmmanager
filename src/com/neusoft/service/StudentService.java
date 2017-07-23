package com.neusoft.service;


import com.neusoft.domain.Page;
import com.neusoft.domain.Students;

public interface StudentService {
	
	public Page selectPageStu(Students students,int pagenum,int pagesize);

}
