package com.neusoft.dao;

import java.util.List;

import com.neusoft.domain.Staff;

public interface StaffDao {

	/**
	 * 根据用户名和密码查询员工信息
	 * @param staff 封装了登录名和密码的Staff对象
	 * @return 查询到的Staff对象
	 */
	public Staff loginStaff(Staff staff);
	
	/**
	 * 查询所有员工信息
	 * @return 所有员工信息的List对象
	 */
	public List<Staff> getAllStaff();
	
	/**
	 * 根据id查询用户信息
	 * @param staffId
	 * @return
	 */
	public Staff getStaffById(String staffId);
	
	/**
	 * 根据id跟新用户
	 * @param staff
	 */
	public void updateStaffById(Staff staff);

	public void saveStaff(Staff staff);
	
	public int getCount();
	
	public List<Staff> getpage(int pagenum,int pagesize);
	
	public List<Staff> getStaffBySeach(Staff staff,int pagenum,int pagesize);
	public int getSerchCount(Staff staff);
	
}
