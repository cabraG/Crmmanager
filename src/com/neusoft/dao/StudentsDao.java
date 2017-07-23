package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.Students;

public interface StudentsDao {
	public List<Students> SelectStu(Students student,int pagenum,int pagesize);
	public int getCountStu(Students student);

}
