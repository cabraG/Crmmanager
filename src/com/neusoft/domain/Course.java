package com.neusoft.domain;

public class Course {
	private String courseId;
	private String courseName;
	private String summary;
	private String courseTime;
	private String courseTimeStart;
	private String courseTimeEnd;
	
	public String getCourseTimeStart() {
		return courseTimeStart;
	}
	public void setCourseTimeStart(String courseTimeStart) {
		this.courseTimeStart = courseTimeStart;
	}
	public String getCourseTimeEnd() {
		return courseTimeEnd;
	}
	public void setCourseTimeEnd(String courseTimeEnd) {
		this.courseTimeEnd = courseTimeEnd;
	}
	private String courseCast;
	private String courseCastStart;
	private String courseCastEnd;
	public String getCourseCastStart() {
		return courseCastStart;
	}
	public void setCourseCastStart(String courseCastStart) {
		this.courseCastStart = courseCastStart;
	}
	public String getCourseCastEnd() {
		return courseCastEnd;
	}
	public void setCourseCastEnd(String courseCastEnd) {
		this.courseCastEnd = courseCastEnd;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getCourseCast() {
		return courseCast;
	}
	public void setCourseCast(String courseCast) {
		this.courseCast = courseCast;
	}
	
}
