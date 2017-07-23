package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.neusoft.dao.StaffDao;
import com.neusoft.domain.Staff;
import com.neusoft.util.C3P0Utils;

public class StaffDaoImpl implements StaffDao {

	@Override
	public Staff loginStaff(Staff staff) {

		String sql = "select * from crm_staff s where s.loginName = ? and s.loginPwd = ?";

		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanHandler<Staff>(Staff.class),
					staff.getLoginName(), staff.getLoginPwd());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Staff> getAllStaff() {

		String sql = "select s.staffId,s.staffName,s.postId,s.gender,s.onDutyDate,d.depName,p.postName from crm_staff s,crm_post p,crm_department d "
				+ " where s.postId = p.postId and p.depId = d.depId";
		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanListHandler<Staff>(Staff.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Staff getStaffById(String staffId) {
		String sql = "select s.*,d.depId,d.depName,p.postName from crm_staff s,crm_post p,crm_department d "
				+ " where s.postId = p.postId and p.depId = d.depId and s.staffId = ?";

		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanHandler<Staff>(Staff.class),
					staffId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateStaffById(Staff staff) {
		String sql = "update crm_staff s set s.loginName = ? ,s.loginPwd= ?,s.gender = ?,"
				+ "s.staffName = ?,s.onDutyDate = ?,s.postId = ? where s.staffId = ?";

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			runner.update(sql, staff.getLoginName(), staff.getLoginPwd(),
					staff.getGender(), staff.getStaffName(),
					staff.getOnDutyDate(), staff.getPostId(),
					staff.getStaffId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void saveStaff(Staff staff) {
		String sql = "insert into crm_staff values(UUID(),?,?,?,?,?,?)";

		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			runner.update(sql, staff.getLoginName(), staff.getLoginPwd(),
					staff.getStaffName(), staff.getGender(),
					staff.getOnDutyDate(), staff.getPostId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public int getCount() {
		String sql = "select count(*) from crm_staff";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

		try {
			return ((Long) runner.query(sql, new ScalarHandler())).intValue();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Staff> getpage(int pagenum, int pagesize) {

		String sql = "select s.staffId,s.staffName,s.postId,s.gender,s.onDutyDate,d.depName,p.postName from crm_staff s,crm_post p,crm_department d "
				+ " where s.postId = p.postId and p.depId = d.depId ORDER BY s.staffId limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

			return runner.query(sql, new BeanListHandler<Staff>(Staff.class),
					(pagenum - 1) * pagesize, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Staff> getStaffBySeach(Staff staff,int pagenum,int pagesize) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		StringBuffer sql = new StringBuffer(
				"select s.staffId,s.staffName,s.postId,s.gender,s.onDutyDate,d.depName,p.postName from crm_staff s,crm_post p,crm_department d "
						+ " where s.postId = p.postId and p.depId = d.depId");
		
		List<Object> list = new ArrayList<Object>();

		if (staff.getDepId() != null && !staff.getDepId().trim().isEmpty()) {
			sql.append(" and d.depId = ?");
			list.add(staff.getDepId());
		}
		
		if (staff.getPostId() != null && !staff.getPostId().trim().isEmpty()) {
			sql.append(" and p.postId = ?");
			list.add(staff.getPostId());
		}
		if (staff.getStaffName() != null && !staff.getStaffName().trim().isEmpty()) {
			sql.append(" and s.staffName like ?");
			list.add("%"+staff.getStaffName()+"%");
		}
		sql.append(" limit ?,?");
		list.add((pagenum-1)*pagesize);
		list.add(pagesize);
		
		try {
			return runner.query(sql.toString(),new BeanListHandler<Staff>(Staff.class),list.toArray());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		// TODO Auto-generated method stub

	}

	@Override
	public int getSerchCount(Staff staff) {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		StringBuffer sql = new StringBuffer(
				"select count(s.staffId) from crm_staff s,crm_post p,crm_department d "
						+ " where s.postId = p.postId and p.depId = d.depId");
		
		List<Object> list = new ArrayList<Object>();

		if (staff.getDepId() != null && !staff.getDepId().trim().isEmpty()) {
			sql.append(" and d.depId = ?");
			list.add(staff.getDepId());
		}
		
		if (staff.getPostId() != null && !staff.getPostId().trim().isEmpty()) {
			sql.append(" and p.postId = ?");
			list.add(staff.getPostId());
		}
		if (staff.getStaffName() != null && !staff.getStaffName().trim().isEmpty()) {
			sql.append(" and s.staffName like ?");
			list.add("%"+staff.getStaffName()+"%");
		}
		
		try {
			return ((Long) runner.query(sql.toString(), new ScalarHandler(),list.toArray())).intValue();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
