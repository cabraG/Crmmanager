package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.CrmClass;
import com.neusoft.domain.Page;

public interface ClassService {
	public Page getPageClass(int pagenum,int pagesize);
public void insertClass(CrmClass crmClass);
public List<CrmClass> getCrmClassById(String classid);
}
