package com.neusoft.domain;

import java.util.Date;

public class CrmClass {
	private String classId;

	private String className;
	private String courseId;
	private String courseName;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	private Date classStart;
	private Date classEnd;
	private String remark;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Date getClassStart() {
		return classStart;
	}
	public void setClassStart(Date classStart) {
		this.classStart = classStart;
	}
	public Date getClassEnd() {
		return classEnd;
	}
	public void setClassEnd(Date classEnd) {
		this.classEnd = classEnd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(int upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public int getChangeCount() {
		return changeCount;
	}
	public void setChangeCount(int changeCount) {
		this.changeCount = changeCount;
	}
	public int getRunoffCount() {
		return runoffCount;
	}
	public void setRunoffCount(int runoffCount) {
		this.runoffCount = runoffCount;
	}
	private String status;
	private int totalCount;
	private int upgradeCount;
	private int changeCount;
    private int runoffCount;

}
