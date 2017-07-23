package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.DepartmentDao;
import com.neusoft.domain.Department;
import com.neusoft.util.C3P0Utils;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> getAllDepartment() {

		String sql = "select * from crm_department";

		try {

			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanListHandler<Department>(Department.class));

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Department> getPageDepartment(Department department,
			int pagenum, int pagesize) {
		StringBuffer sql = new StringBuffer("select * from crm_department where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		try {
			if(department.getDepName()!=null && !department.getDepName().trim().isEmpty())
			{
				sql.append(" and depName like ?");
				list.add("%"+department.getDepName()+"%");
			}
			if(department.getDepId()!=null && !department.getDepId().trim().isEmpty())
			{
				sql.append(" and depId like ?");
				list.add("%"+department.getDepId()+"%");
			}
			sql.append(" limit ?,?");
			list.add((pagenum-1)*pagesize);
			list.add(pagesize);
			
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql.toString(), new BeanListHandler<Department>(Department.class),list.toArray());

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getDepCount(Department department) {
		StringBuffer sql = new StringBuffer("select count(*) from crm_department where 1=1 ");
		List<Object> list=new ArrayList<Object>();
		try {
			if(department.getDepName()!=null && !department.getDepName().trim().isEmpty())
			{
				sql.append(" and depName like ?");
				list.add("%"+department.getDepName()+"%");
			}
			
			
			
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return ((Long) runner.query(sql.toString(), new ScalarHandler(),list.toArray())).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateDep(Department department) {
		
		String sql="update crm_department d set depName=? where d.depId=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql,department.getDepName(),department.getDepId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void insertDep(Department department) {
		
		// TODO Auto-generated method stub
	
		String sql="insert into crm_department values(uuid(),?)";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql,department.getDepName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


