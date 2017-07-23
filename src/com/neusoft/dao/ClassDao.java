package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.CrmClass;

public interface ClassDao {
	public List<CrmClass> getPageClass(int pagenum,int pagesize);
	public int getCountClass();
	public void insertClass(CrmClass crmclass);
	public List<CrmClass> selectClassByClassId(String classid);
	

}
