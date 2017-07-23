package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.neusoft.dao.StudentsDao;
import com.neusoft.domain.Students;
import com.neusoft.util.C3P0Utils;

public class StudentsDaoImpl implements StudentsDao {

	@Override
	public List<Students> SelectStu(Students student, int pagenum, int pagesize) {
		try {
		StringBuffer sql = new StringBuffer("select s1.*,s2.statusName,c.className from crm_students s1,crm_status s2,crm_class c where s1.statusId=s2.statusId and s1.classId=c.classId");
		List<Object> list=new ArrayList<Object>();
		String targetse=student.getTargetse();
		String classid=student.getClassId();
		if(StringUtils.isNotBlank(classid)){
			   sql.append(" and s1.classId= ? ");
			   list.add(classid);
			   
			}
		sql.append(" group by s1.stuId ");
		if(StringUtils.isNotBlank(targetse)){
			sql.append(" having  s1.stuname like ? or s1.stuphone like ? or s1.qq like ? ");
			
			list.add("%"+targetse+"%");
			list.add("%"+targetse+"%");
			list.add("%"+targetse+"%");
			
		}
	
		sql.append(" limit ?,?");
		list.add((pagenum-1)*pagesize);
		list.add(pagesize);
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		
			return runner.query(sql.toString(), new BeanListHandler<Students>(Students.class),list.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCountStu(Students student) {
		try {
		StringBuffer sql = new StringBuffer("select count(*) from crm_students s1,crm_status s2,crm_class c where s1.statusId=s2.statusId and s1.classId=c.classId");
		List<Object> list=new ArrayList<Object>();
		String targetse=student.getTargetse();
		String classid=student.getClassId();
		if(StringUtils.isNotBlank(targetse)){
			sql.append(" or s1.stuname like ? or s1.stuphone like ? or s1.qq like ? ");
			
			list.add("%"+targetse+"%");
			list.add("%"+targetse+"%");
			list.add("%"+targetse+"%");
			
		}
		if(StringUtils.isNotBlank(classid)){
		   sql.append(" and s1.classId = ? ");
		   list.add(classid);
		   
		}
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
			return ((Long) runner.query(sql.toString(), new ScalarHandler(),list.toArray())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
