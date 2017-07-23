package com.neusoft.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.ClassDao;
import com.neusoft.domain.CrmClass;
import com.neusoft.util.C3P0Utils;

public class ClassDaoImpl implements ClassDao{

	@Override
	public List<CrmClass> getPageClass(int pagenum,int pagesize ) {
		try {
		String sql="select cl.*,co.courseName from crm_class cl,crm_course co where cl.courseId=co.courseId limit ?,?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		return runner.query(sql, new BeanListHandler<CrmClass>(CrmClass.class),(pagenum - 1) * pagesize, pagesize);
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	}

	@Override
	public int getCountClass() {
		try {
		String sql="select count(cl.classId) from crm_class cl,crm_course co where cl.courseId=co.courseId";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
			return ((Long) runner.query(sql.toString(), new ScalarHandler())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertClass(CrmClass crmclass) {
		String sql="insert into crm_class values(uuid(),?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql, crmclass.getClassName(),crmclass.getCourseId(),crmclass.getRemark(),crmclass.getClassStart(),crmclass.getClassEnd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CrmClass> selectClassByClassId(String classid) {
		try {
		String sql="select classId,className from crm_class where courseId= ?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
	
			return runner.query(sql,new BeanListHandler<CrmClass>(CrmClass.class),classid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
