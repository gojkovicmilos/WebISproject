package DTO;

import lms.domain.Course;

public class CourseGradeDTO {
	
	private Course course;
	private int grade;
	
	public CourseGradeDTO() {
	}

	public CourseGradeDTO(Course course, int grade) {
		this.course = course;
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

}
