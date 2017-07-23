package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.StaffDao;
import com.neusoft.dao.impl.StaffDaoImpl;
import com.neusoft.domain.Page;
import com.neusoft.domain.Staff;
import com.neusoft.service.StaffService;
import com.neusoft.util.MyStringUtils;

public class StaffServiceImpl implements StaffService {
	
	StaffDao staffDao = new StaffDaoImpl();

	@Override
	public Staff loginStaff(Staff staff) {
		
		String loginPwd = staff.getLoginPwd();
		String md5Value = MyStringUtils.getMD5Value(loginPwd);
		staff.setLoginPwd(md5Value);
		
		return staffDao.loginStaff(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		return staffDao.getAllStaff();
	}

	@Override
	public Staff getStaffById(String staffId) {
		return staffDao.getStaffById(staffId);
	}

	@Override
	public void updateStaffById(Staff staff) {
		String loginPwd = staff.getLoginPwd();
		
		if(loginPwd.length()==32) {
			staffDao.updateStaffById(staff);
		} else {
			String md5Value = MyStringUtils.getMD5Value(loginPwd);
			staff.setLoginPwd(md5Value);
			staffDao.updateStaffById(staff);
		}
		
		
	}

	@Override
	public void saveStaff(Staff staff) {
	String loginPwd = staff.getLoginPwd();
		
		if(loginPwd.length()==32) {
			staffDao.updateStaffById(staff);
		} else {
			String md5Value = MyStringUtils.getMD5Value(loginPwd);
			staff.setLoginPwd(md5Value);
			staffDao.saveStaff(staff);
		}
		
		
	}

	@Override
	public Page getStaffByPage(int pagenum,int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		page.setCount(staffDao.getCount());
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
		List<Staff> stafflist=staffDao.getpage(pagenum, pagesize);
		page.setStafflist(stafflist);
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return staffDao.getCount();
	}

	@Override
	public  Page getFindStaff(Staff staff,int pagenum,int pagesize) {
		Page page=new Page();
		page.setPagenum(pagenum);
		page.setPagesize(pagesize);
		List<Staff> stafflist=staffDao.getStaffBySeach(staff, pagenum, pagesize);
		page.setStafflist(stafflist);
		page.setCount(staffDao.getSerchCount(staff));
		page.setPages((page.getCount()%page.getPagesize()==0)?page.getCount()/page.getPagesize():page.getCount()/page.getPagesize()+1);
		// TODO Auto-generated method stub
		return page;
	}

	

	

}
