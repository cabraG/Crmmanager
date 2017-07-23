package com.neusoft.service;

import java.util.List;

import com.neusoft.domain.Page;
import com.neusoft.domain.Staff;

public interface StaffService {

	/**
	 * 登录用户
	 * @param staff
	 * @return
	 */
	public Staff loginStaff(Staff staff);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<Staff> getAllStaff();
	public Page getStaffByPage(int pagenum,int pagesize);
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
	
	public Page getFindStaff(Staff staff,int pagenum,int pagesize);

	
}
