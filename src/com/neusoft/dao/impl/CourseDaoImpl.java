package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringUtils;

import com.neusoft.dao.CourseDao;
import com.neusoft.domain.Course;
import com.neusoft.util.C3P0Utils;

public class CourseDaoImpl implements CourseDao{

	@Override
	public List<Course> getPageCourse(Course course, int pagenum, int pagesize) {
		try {
		StringBuffer sql = new StringBuffer("select * from crm_course where 1=1");
		
		List<Object> list=new ArrayList<Object>();
		String courseName=course.getCourseName();
		String summary=course.getSummary();
		String courseTimeStart=course.getCourseTimeStart();
		String courseTimeEnd=course.getCourseTimeEnd();
		String courseCastStart=course.getCourseCastStart();
		String courseCastEnd=course.getCourseCastEnd();
		if(StringUtils.isNotBlank(courseName)){
			sql.append(" and courseName like ?");
			list.add("%"+courseName+"%");
		}
		if(StringUtils.isNotBlank(summary)){
			sql.append(" and summary like ?");
			list.add("%"+summary+"%");
		}
		if(StringUtils.isNotBlank(courseTimeStart)){
			sql.append(" and courseTime >= ?");
			list.add(courseTimeStart);
		}
		if(StringUtils.isNotBlank(courseTimeEnd)){
			sql.append(" and courseTime <= ?");
			list.add(courseTimeEnd);
		}
           if(StringUtils.isNotBlank(courseCastStart)){
			sql.append(" and courseCast > ?");
			list.add(courseCastStart);
		}
           if(StringUtils.isNotBlank(courseCastEnd)){
   			sql.append(" and courseCast < ?");
   			list.add(courseCastEnd);
   		}
		sql.append(" limit ?,?");
		list.add((pagenum-1)*pagesize);
		list.add(pagesize);
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		
		
		
			return runner.query(sql.toString(), new BeanListHandler<Course>(Course.class),list.toArray());
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCourseCount(Course course) {
StringBuffer sql = new StringBuffer("select count(courseId) from crm_course where 1=1");
try {
		List<Object> list=new ArrayList<Object>();
		String courseName=course.getCourseName();
		String summary=course.getSummary();
		String courseTimeStart=course.getCourseTimeStart();
		String courseTimeEnd=course.getCourseTimeEnd();
		String courseCastStart=course.getCourseCastStart();
		String courseCastEnd=course.getCourseCastEnd();
		if(StringUtils.isNotBlank(courseName)){
			sql.append(" and courseName like ?");
			list.add("%"+courseName+"%");
		}
		if(StringUtils.isNotBlank(summary)){
			sql.append(" and summary like ?");
			list.add("%"+summary+"%");
		}
		if(StringUtils.isNotBlank(courseTimeStart)){
			sql.append(" and courseTime >= ?");
			list.add(courseTimeStart);
		}
		if(StringUtils.isNotBlank(courseTimeEnd)){
			sql.append(" and courseTime <= ?");
			list.add(courseTimeEnd);
		}
           if(StringUtils.isNotBlank(courseCastStart)){
			sql.append(" and courseCast >= ?");
			list.add(courseCastStart);
		}
           if(StringUtils.isNotBlank(courseCastEnd)){
   			sql.append(" and courseCast <= ?");
   			list.add(courseCastEnd);
   		}
       	QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
       
			return ((Long) runner.query(sql.toString(), new ScalarHandler(),list.toArray())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertCourse(Course course) {
		try {
		String sql="insert into crm_course values(uuid(),?,?,?,?)";
	 	QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	 	
			runner.update(sql,course.getCourseName(),course.getSummary(),course.getCourseCast(),course.getCourseTime());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Course getCourseById(String courseId) {
		try {
		String sql="select * from crm_course where courseId=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
			return runner.query(sql, new BeanHandler<Course>(Course.class),courseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCourse(Course course) {
		String sql="update crm_course set  courseName = ?,summary= ?,courseCast= ?,courseTime= ? where courseId=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql,course.getCourseName(),course.getSummary(),course.getCourseCast(),course.getCourseTime(),course.getCourseId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
